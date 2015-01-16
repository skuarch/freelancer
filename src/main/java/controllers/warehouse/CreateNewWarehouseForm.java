package controllers.warehouse;

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
public class CreateNewWarehouseForm {

    @Autowired
    MessageSource messageSource;
    private static final Logger logger = Logger.getLogger(CreateNewWarehouseForm.class);

    //==========================================================================
    @RequestMapping(value = {"/createNewWarehouseForm", "createNewWarehouseForm"})
    public ModelAndView createNewWarehouseForm(Locale locale) {

        ModelAndView mav = null;

        try {

            mav = new ModelAndView("warehouse/createNewWarehouseForm");

        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;

    }

}
