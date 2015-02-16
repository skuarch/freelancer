package controllers.freelancer;

import controllers.application.BaseController;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import model.beans.Freelancer;
import model.util.FreelancerUtil;
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
public class FreelancerCreateEstablishment extends BaseController {
  
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private HttpSession session;
    private static final Logger logger = Logger.getLogger(FreelancerCreateEstablishment.class);
    
    //==========================================================================
    @RequestMapping(value = {"createEstablishment","/createEstablishment"})
    public ModelAndView createEstablishment(@RequestParam long id, Locale locale){
        
        ModelAndView mav = new ModelAndView("establishment/createEstablishment");
        Freelancer freelancer = null;
        
        try {
            
            if(id < 1){
                mav.setViewName("application/systemWelcome");
                return mav;
            }          
            
            freelancer = FreelancerUtil.getFreelancer(session);
            
        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }
        
        return mav;
    
    }
    
}
