package controllers.establishment;

import controllers.application.BaseController;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import model.util.HandlerExceptionUtil;
import model.util.SessionUtil;
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
public class EstablishmentDetails extends BaseController {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private HttpSession session;
    private static final Logger logger = Logger.getLogger(EstablishmentDetails.class);
    
    @RequestMapping(value = {"/establishmentDetails","establishmentDetails"})
    public ModelAndView establishmentDetails(Locale locale){
    
        ModelAndView mav = new ModelAndView("establishment/establishmentDetails");
        short establishmentId;
        
        try {
            
            establishmentId = SessionUtil.getShortParameter(session, "establishmentId");
            
            if (establishmentId < 1) {
                mav.setViewName("application/systemWelcome");
                return mav;
            }            
            
            mav.addObject("establishmentId", establishmentId);
            
        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }
        
        return mav;
        
    }
    
}
