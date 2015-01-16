package controllers.product;

import controllers.application.BaseController;
import java.util.ArrayList;
import java.util.Locale;
import model.beans.Category;
import model.database.CategoryModel;
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
public class NewProductForm extends BaseController {

    @Autowired
    private MessageSource messageSource;
    private static final Logger logger = Logger.getLogger(NewProductForm.class);

    @RequestMapping(value = {"createNewProductForm", "/createNewProductForm"}, method = RequestMethod.GET)
    public ModelAndView processRequest(Locale locale) {

        ModelAndView mav = new ModelAndView("products/createNewProductForm");
        ArrayList<Category> categories = null;

        try {

            categories = CategoryModel.getCategories();
            mav.addObject("categories", categories);

        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;

    }
}
