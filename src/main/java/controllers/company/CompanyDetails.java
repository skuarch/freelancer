package controllers.company;

import java.util.Locale;
import javax.servlet.http.HttpSession;
import model.util.HandlerExceptionUtil;
import model.util.SessionUtil;
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
public class CompanyDetails {

    private static final Logger logger = Logger.getLogger(CompanyDetails.class);

    @Autowired
    private MessageSource messageSource;    
    @Autowired
    private HttpSession session;

    //==========================================================================

    @RequestMapping(value = {"/companyDetails", "companyDetails"})
    public ModelAndView companyDetails(Locale locale) {

        ModelAndView mav = new ModelAndView();
        long companyId = 0;

        try {
            
            companyId = SessionUtil.getShortParameter(session, "companyId");
            
            if (companyId < 1) {
                mav.setViewName("application/systemWelcome");
                return mav;
            }            
            
            mav.setViewName("company/companyDetailsContainer");
            mav.addObject("companyId", companyId);
            
        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;

    }

}
