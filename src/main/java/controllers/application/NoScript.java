package controllers.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class NoScript {
    
    @RequestMapping(value = {"noscript","/noscript"})
    public ModelAndView noscript(ModelAndView mav){    
        mav.setViewName("application/noscript");
        return mav;
    }
    
}