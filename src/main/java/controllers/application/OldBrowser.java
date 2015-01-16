package controllers.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class OldBrowser extends BaseController {

    //==========================================================================
    @RequestMapping(value = {"oldBrowser", "/oldBrowser",})
    public ModelAndView oldBrowser(ModelAndView mav) {
        mav.setViewName("application/oldBrowser");
        return mav;
    }

}
