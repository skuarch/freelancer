package controllers.freelancer;

import controllers.application.BaseController;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class UpdateFreelancerPasswordProcess extends BaseController {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private HttpSession session;
    private static final Logger logger = Logger.getLogger(UpdateFreelancerPasswordProcess.class);
    
    //==========================================================================
    @RequestMapping(value = {"/updateFreelancerPasswordProcess", "updateFreelancerPasswordProcess"}, method = RequestMethod.POST)
    public ModelAndView updatePassword(@RequestParam String currentPassword, @RequestParam String newPassword, @RequestParam String newPassword2, HttpServletResponse response, Locale locale) {

        ModelAndView mav = new ModelAndView("application/json");
        HashMap<String, Object> parameters = null;
        String json = null;
        JSONObject jsono = null;
        Freelancer freelancer = null;
        
        try {
            
            setHeaderNoChache(response);
            
            freelancer = FreelancerUtil.getFreelancer(session);
            parameters = FreelancerUtil.createHashMapFreelancerUpdatePassword(
                    currentPassword, 
                    newPassword, 
                    newPassword2,
                    freelancer.getId());
            json = RestPostClient.sendReceive(
                    parameters, 
                    Constants.API_URL, 
                    Constants.API_FIRST_VERSION, 
                    Constants.URI_FREELANCER_UPDATE_PASSWORD);
            jsono = new JSONObject(json);            
            mav.addObject("json", jsono);
            
        } catch (IOException | JSONException e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text116");
        }

        return mav;
    }

}
