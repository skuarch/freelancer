package controllers.cashier;

import com.google.gson.Gson;
import controllers.application.BaseController;
import java.util.HashMap;
import java.util.Locale;
import model.beans.Cashier;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.ApplicationUtil;
import model.util.HandlerExceptionUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class CashierDetails extends BaseController{

    @Autowired
    private MessageSource messageSource;
    private static final Logger logger = Logger.getLogger(CashierDetails.class);
    
    //==========================================================================
    @RequestMapping(value = {"cashierDetails", "/cashierDetails"})
    public ModelAndView cashierDetails(@RequestParam long cashierId, Locale locale){
    
        ModelAndView mav = null;
        HashMap parameters = null;
        String json = null;
        Cashier cashier = null;
        
        try {
            
            mav = new ModelAndView("cashier/cashierDetails");
            parameters = ApplicationUtil.createParameters(cashierId);
            json = RestPostClient.sendReceive(parameters, 
                    Constants.API_URL, 
                    Constants.API_FIRST_VERSION, 
                    Constants.URI_CASHIER_GET);
            cashier = new Gson().fromJson(json, Cashier.class);
            mav.addObject("cashier", cashier);            
            
        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }
        
        return mav;
        
    }
    
}
