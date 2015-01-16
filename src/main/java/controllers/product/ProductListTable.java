package controllers.product;

import java.util.ArrayList;
import java.util.Locale;
import model.beans.Product;
import model.database.DAO;
import model.util.HandlerExceptionUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class ProductListTable {

    @Autowired
    private MessageSource messageSource;
    private static final Logger logger = Logger.getLogger(ProductListTable.class);
    
    //==========================================================================
    @RequestMapping(value = {"productListTable.html"}, method = RequestMethod.GET)
    public ModelAndView productListTable(Locale locale) {

        ModelAndView mav = new ModelAndView("products/productListTable");
        ArrayList<Product> productList = null;

        try {
            
            productList = new DAO().getArrayList(new Product());
            mav.addObject("productList", productList);            

        } catch (Exception e) {            
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;
    }

}
