package controllers.product;

import controllers.application.BaseController;
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
public class ProductList extends BaseController {

    @Autowired
    private MessageSource messageSource;
    private static final Logger logger = Logger.getLogger(ProductList.class);

    //==========================================================================
    @RequestMapping(value = {"productList", "/productList"}, method = RequestMethod.GET)
    public ModelAndView productList(Locale locale) {

        ModelAndView mav = null;

        try {

            mav = new ModelAndView("products/productListContainer");

        } catch (Exception e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text41");
        }

        return mav;

    }

}
