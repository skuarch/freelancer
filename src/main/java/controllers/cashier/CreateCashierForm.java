package controllers.cashier;

import java.util.Locale;
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
public class CreateCashierForm {

    @Autowired
    private MessageSource messageSource;
    private static final Logger logger = Logger.getLogger(CreateCashierForm.class);
    
    //==========================================================================
    @RequestMapping(value = {"/createCashierForm", "createCashierForm"})
    public ModelAndView methodName(@RequestParam long establishmentId, Locale locale){        
        
        ModelAndView mav = null;

        try {
            
            mav = new ModelAndView("cashier/newCashier");
            mav.addObject("establishmentid", establishmentId);
            
        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;

    }

}
