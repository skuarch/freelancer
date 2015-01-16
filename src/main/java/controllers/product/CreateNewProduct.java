package controllers.product;

import controllers.application.BaseController;
import java.util.Locale;
import model.util.HandlerExceptionUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class CreateNewProduct extends BaseController {

    @Autowired
    MessageSource messageSource;
    private static final Logger logger = Logger.getLogger(CreateNewProduct.class);

    //==========================================================================
    @RequestMapping(value = {"createNewProduct", "/createNewProduct"})
    public ModelAndView createNewProduct(Locale locale) {

        ModelAndView mav = null;

        try {

            mav = new ModelAndView("products/createNewProduct");            

        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;

    }

}
