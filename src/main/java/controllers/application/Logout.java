package controllers.application;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class Logout extends BaseController{
    
    @RequestMapping(value = {"/logout","logout"})
    public ModelAndView logout(ModelAndView mav,HttpServletResponse response){
        
        setHeaderNoChache(response);
        mav.setViewName("application/logout");
        return mav;
        
    }
    
}
