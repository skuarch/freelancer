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
public class CreateFreelancer extends BaseController {

    @RequestMapping(value = {"/createFreelancer", "createFreelancer"})
    public ModelAndView createFreelancer() {

        ModelAndView mav = null;
        
        try {

            mav = new ModelAndView("freelancer/createFreelancer");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return mav;

    }

}
