package controllers.dashboard;

import controllers.application.BaseController;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class Dashboard extends BaseController {    
    
    //==========================================================================
    @RequestMapping(value = {"dashboard","/dashboard"})
    public ModelAndView showDashboard(ModelAndView mav,HttpServletResponse response){
        setHeaderNoChache(response);  
        mav.setViewName("dashboard/index");
        return mav;    
    }
    
}
