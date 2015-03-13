package controllers.affiliate;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import model.beans.Affiliate;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.ApplicationUtil;
import model.util.HandlerExceptionUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class AffiliateDetailsForm {

    @Autowired
    private MessageSource messageSource;
    private static final Logger logger = Logger.getLogger(AffiliateDetailsForm.class);

    //==========================================================================
    @RequestMapping(value = "affiliateDetailsForm")
    public ModelAndView affiliateDetailsForm(@RequestParam long id, Locale locale) {

        ModelAndView mav = null;
        Affiliate affiliate = null;
        HashMap<String,Object> parameters = null;
        String json = null;

        try {

            if (id < 1) {
                mav = new ModelAndView("application/systemWelcome");                
                return mav;
            }

            mav = new ModelAndView("affiliate/affiliateDetialsForm");
            mav.addObject("id", id);
            
            parameters = ApplicationUtil.createParameters(id);
            json = RestPostClient.sendReceive(
                    parameters, 
                    Constants.API_URL, 
                    Constants.API_FIRST_VERSION, 
                    Constants.URI_AFFILIATE_GET);
            
            affiliate = new Gson().fromJson(json, Affiliate.class);
            mav.addObject("affiliate", affiliate);            

        } catch (IOException | JsonSyntaxException e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;

    }

}
