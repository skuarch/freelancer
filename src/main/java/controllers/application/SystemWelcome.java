package controllers.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class SystemWelcome extends BaseController {
    
    //==========================================================================
    @RequestMapping(value = {"/systemWelcome","systemWelcome"})
    public ModelAndView welcome(){
    
        ModelAndView mav = null;
        
        try {
            
            mav = new ModelAndView("application/systemWelcome");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return mav;
    
    }
    
}