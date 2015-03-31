package controllers.affiliate;

import org.springframework.web.servlet.ModelAndView;
import controllers.application.BaseController;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import model.util.HandlerExceptionUtil;
import model.util.SessionUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author skuarch
 */
@Controller
public class AffiliateDetails extends BaseController {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private HttpSession session;
    private static final Logger logger = Logger.getLogger(AffiliateDetails.class);
    
    //==========================================================================
    @RequestMapping(value = {"affiliateDetails"})
    public ModelAndView affiliateDetails(Locale locale) {
        
        ModelAndView mav = new ModelAndView("affiliate/affiliateDetails");
        long affiliateId = 0;

        try {

            affiliateId = SessionUtil.getLongParameter(session, "affiliateId");
            
            if (affiliateId < 1) {
                mav.setViewName("application/systemWelcome");
                return mav;
            }            
            
            mav.addObject("affiliateId", affiliateId);

        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;

    }

}
