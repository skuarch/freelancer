package controllers.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class TestNotificationsForm extends BaseController{
    
    //==========================================================================
    @RequestMapping(value = {"testNotificationsForm","/testNotificationsForm"})
    public ModelAndView testNotifications(ModelAndView mav){
        mav.setViewName("application/testNotificationsForm");
        return mav;
    }
    
}
