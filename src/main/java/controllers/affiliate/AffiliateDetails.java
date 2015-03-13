package controllers.affiliate;

import org.springframework.web.servlet.ModelAndView;
import controllers.application.BaseController;
import java.util.Locale;
import model.util.HandlerExceptionUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author skuarch
 */
@Controller
public class AffiliateDetails extends BaseController {

    @Autowired
    private MessageSource messageSource;
    private static final Logger logger = Logger.getLogger(AffiliateDetails.class);
    
    //==========================================================================
    @RequestMapping(value = {"affiliateDetails"})
    public ModelAndView affiliateDetails(@RequestParam long id, Locale locale) {

        ModelAndView mav = new ModelAndView();

        try {

            if (id < 1) {
                mav.setViewName("application/systemWelcome");
                return mav;
            }
            
            mav.setViewName("affiliate/affiliateDetails");
            mav.addObject("id", id);

        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;

    }

}
