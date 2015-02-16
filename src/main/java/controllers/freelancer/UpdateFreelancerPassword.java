package controllers.freelancer;

import controllers.application.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class UpdateFreelancerPassword extends BaseController {
    
    //==========================================================================
    @RequestMapping(value = {"/updateFreelancerPassword", "updateFreelancerPassword"})
     public ModelAndView updatePassword(){
     
         ModelAndView mav = new ModelAndView("freelancer/updateFreelancerPassword");
         return mav;
         
     }
    
}
