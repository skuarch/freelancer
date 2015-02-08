package controllers.freelancer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import model.beans.Freelancer;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.FreelancerUtil;
import model.util.HandlerExceptionUtil;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author skuarch
 */
@Controller
public class UpdateFreelancerProcess {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private HttpSession session;
    private static final Logger logger = Logger.getLogger(UpdateFreelancerProcess.class);

    //==========================================================================    
    @RequestMapping(value = {"/updateFreelancerProfileProcess", "updateFreelancerProfileProcess"})
    public ModelAndView updateFreelancerProcess(@ModelAttribute Freelancer freelancer, Locale locale) {
        
        HashMap<String, Object> parameters = null;
        String json = null;
        ModelAndView mav = new ModelAndView("application/json");
        JSONObject jsono = null;
        Freelancer freelancerSession = null;

        try {

            freelancerSession = FreelancerUtil.getFreelancer(session);
            freelancer.setId(freelancerSession.getId());
            freelancer.setKey(freelancerSession.getKey());
            
            parameters = FreelancerUtil.createHashMapFreelancer(freelancer);            
            json = RestPostClient.sendReceive(parameters, Constants.URI_FREELANCER_UPDATE);            
            jsono = new JSONObject(json);            
            mav.addObject("json", jsono);
            
            FreelancerUtil.resetFreelancerSession(session, freelancer);

        } catch (IOException | JSONException e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text116");
        }

        return mav;

    }
}
