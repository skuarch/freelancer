package controllers.affiliate;

import java.util.HashMap;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.ApplicationUtil;
import model.util.HandlerExceptionUtil;
import model.util.SessionUtil;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch-lap
 */
@Controller
public class UpdateAffiliatePasswordProcess {
    
    @Autowired
    private MessageSource messageSource;    
    @Autowired
    private HttpSession session;
    
    private static final Logger logger = Logger.getLogger(UpdateAffiliatePasswordProcess.class);
    
    @RequestMapping(value = "updateAffiliatePasswordProcess")
    public ModelAndView updateAffiliatePassword(            
            @RequestParam("password") String password,
            @RequestParam("password2") String password2,
            Locale locale){
    
        ModelAndView mav = null;
        HashMap<String, Object> parameters;
        String json;
        JSONObject jsono;
        long affiliateId;
        
        try {            
            
            affiliateId = SessionUtil.getShortParameter(session, "affiliateId");
            
            parameters = ApplicationUtil.createParametersFreelancerUpdateAffiliatePassword(affiliateId, password2, password2);
            
            json = RestPostClient.sendReceive(
                    parameters,
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    Constants.URI_AFFILIATE_UPDATE_PASSWORD);
            System.out.println("que mierdas " + json);
            mav = new ModelAndView("application/json");
            jsono = new JSONObject(json);
            mav.addObject("json", jsono);
            
        } catch (Exception e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text116");
        }
        
        return mav;
        
    }
}
