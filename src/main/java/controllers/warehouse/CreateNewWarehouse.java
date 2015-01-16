package controllers.warehouse;

import controllers.application.BaseController;
import java.util.Locale;
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
public class CreateNewWarehouse extends BaseController {

    @Autowired
    MessageSource messageSource;
    private static final Logger logger = Logger.getLogger(CreateNewWarehouse.class);
    
    //==========================================================================
    @RequestMapping(value = {"createNewWarehouse","/createNewWarehouse"}, method = RequestMethod.GET)
    public ModelAndView createNewWarehouse(Locale locale) {

        ModelAndView mav = null;

        try {
            
            mav = new ModelAndView("warehouse/createNewWarehouse");

        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;
    }

}
