package controllers.freelancer;

import controllers.application.BaseController;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import model.beans.FreelancerBasic;
import model.util.HandlerExceptionUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class Profile extends BaseController {

    private static final Logger logger = Logger.getLogger(Profile.class);
    
    @Autowired
    private HttpSession session;
    @Autowired
    MessageSource messageSource;
    private FreelancerBasic freelancerBasic = null;

    //==========================================================================
    @RequestMapping(value = {"/profile", "profile"})
    public ModelAndView profile(Locale locale) {

        ModelAndView mav = new ModelAndView("freelancer/profile");
        
        try {            
            
            freelancerBasic = (FreelancerBasic) session.getAttribute("freelancerBasic");
            mav.addObject("freelancerBasic", freelancerBasic);
            
            
        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;
    }

}
