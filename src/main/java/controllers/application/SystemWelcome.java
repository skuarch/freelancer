package controllers.application;

import javax.servlet.http.HttpSession;
import model.beans.FreelancerBasic;
import model.util.FreelancerUtil;
import model.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class SystemWelcome extends BaseController {
    
    @Autowired
    private HttpSession session;
    
    //==========================================================================
    @RequestMapping(value = {"/systemWelcome","systemWelcome"})
    public ModelAndView welcome(){
    
        ModelAndView mav = null;
        FreelancerBasic fb = null;
        
        try {
            
            fb =  FreelancerUtil.getFreelancerBasic(session);
            mav = new ModelAndView("application/systemWelcome");
            mav.addObject("freelancerBasic", fb);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return mav;
    
    }
    
}