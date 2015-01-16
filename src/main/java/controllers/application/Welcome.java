package controllers.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class Welcome extends BaseController {
    
    //==========================================================================
    @RequestMapping(value = {"/","/welcome","welcome"})
    public ModelAndView welcome(){
    
        ModelAndView mav = null;
        
        try {
            
            mav = new ModelAndView("application/welcome");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return mav;
    
    }
    
}