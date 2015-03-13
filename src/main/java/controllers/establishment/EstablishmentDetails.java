package controllers.establishment;

import controllers.application.BaseController;
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
public class EstablishmentDetails extends BaseController {

    @Autowired
    private MessageSource messageSource;
    private static final Logger logger = Logger.getLogger(EstablishmentDetails.class);
    
    @RequestMapping(value = {"/establishmentDetails","establishmentDetails"})
    public ModelAndView establishmentDetails(@RequestParam long id, Locale locale){
    
        ModelAndView mav = new ModelAndView();
        
        try {
            
            if (id < 1) {
                mav.setViewName("application/systemWelcome");
                return mav;
            }
            
            mav = new ModelAndView("establishment/establishmentDetails");
            mav.addObject("id", id);
            
        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }
        
        return mav;
        
    }
    
}
