package controllers.application;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class Welcome extends BaseController {
    
    private static final Logger logger = Logger.getLogger(Welcome.class);
    
    //==========================================================================
    @RequestMapping(value = {"/","/welcome","welcome"})
    public ModelAndView welcome(){
    
        ModelAndView mav = null;
        
        try {
            
            mav = new ModelAndView("application/welcome");
            
        } catch (Exception e) {
            logger.error("Welcome.welcome", e);
        }
        
        return mav;
    
    }
    
}