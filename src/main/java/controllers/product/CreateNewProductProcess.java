package controllers.product;

import controllers.application.BaseController;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import javax.servlet.http.HttpSession;
import model.beans.Product;
import model.beans.User;
import model.database.ProductModel;
import model.logic.CreateTransactionNewProduct;
import model.logic.NotificationBroadcast;
import model.util.HandlerExceptionUtil;
import model.util.SessionUtil;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class CreateNewProductProcess extends BaseController {

    @Autowired
    private MessageSource messageSource;
    private static final Logger logger = Logger.getLogger(CreateNewProductProcess.class);

    //==========================================================================
    @RequestMapping(value = {"createNewProductProcess", "/createNewProductProcess"}, method = RequestMethod.POST)
    public ModelAndView processRequest(@ModelAttribute Product product, HttpSession session, Locale locale) {

        ModelAndView mav = new ModelAndView("application/json");
        JSONObject jsono = new JSONObject();
        String message = null;
        long id;

        try {

            id = ProductModel.createProduct(product);
            jsono.append("id", id);
            jsono.append("saved", true);
            message = messageSource.getMessage("text42", null, locale) + id;
            jsono.append("message", message);
            mav.addObject("json", jsono.toString());

            runBackgroundTasks(product, SessionUtil.getUser(session));  
            sendNotificationNewProduct();

        } catch (Exception e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text41");            
        }

        return mav;
    }

    //==========================================================================
    private long runBackgroundTasks(final Product product, final User user) throws Exception {

        if(product == null){
            throw new IllegalArgumentException("product is null");
        }
        
        if(user == null){
            throw new IllegalArgumentException("user is null");
        }
        
        long id;
        CreateTransactionNewProduct ctnp = null;
        ExecutorService executor = null;
        FutureTask<Long> ft = null;

        try {

            executor = Executors.newFixedThreadPool(2);
            ctnp = new CreateTransactionNewProduct(product, user);            
            ft = new FutureTask<>(ctnp);
            executor.execute(ft);            
            id = ft.get();

        } catch (InterruptedException | ExecutionException e) {
            throw e;
        } finally {
            if (executor != null) {
                executor.shutdown();
            }
        }

        return id;

    }
    
    //==========================================================================
    private void sendNotificationNewProduct(){
    
        new Thread(() -> {
            NotificationBroadcast.sendMessage("new Product was created");
        }).start();
    
    }

}
