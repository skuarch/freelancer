package controllers.product;

import java.util.Locale;
import model.beans.Product;
import model.database.ProductModel;
import model.util.HandlerExceptionUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class ProductDetails {

    @Autowired
    private MessageSource messageSource;
    private static final Logger logger = Logger.getLogger(ProductDetails.class);
    
    //==========================================================================
    @RequestMapping(value = {"productDetails", "/productDetails"}, method = RequestMethod.POST)
    public ModelAndView productDetails(@RequestParam long id, Locale locale) {

        ModelAndView mav = new ModelAndView("products/productDetails");
        Product product = null;
        
        try {
            
            product = ProductModel.getProduct(id);
            mav.addObject("product", product);           

        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;

    }

}
