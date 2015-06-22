package controllers.application;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Locale;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.beans.AuthenticationBean;
import model.beans.FreelancerBasic;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.HandlerExceptionUtil;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.log4j.Logger;
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
public class Authentication extends BaseController {

    private static final Logger logger = Logger.getLogger(Authentication.class);
    
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private HttpSession session;
    @Autowired
    private AuthenticationBean ab;

    //==========================================================================
    @RequestMapping(value = {"authentication", "/authentication"}, method = RequestMethod.POST)
    public ModelAndView Authentication(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletResponse response, Locale locale) {
        
        HashMap parameters;
        ModelAndView mav = new ModelAndView();        
        JSONObject jsonReturn = null;
        String tmp = null;
        FreelancerBasic freelancerBasic = null;

        try {

            setHeaderNoChache(response);

            mav.setViewName("application/json");

            if (response == null) {
                return mav;
            }

            if (email == null || email.length() < 1 || !email.contains("@")) {
                ab.setVerify("false");
                return mav;
            }

            if (password == null || password.length() != 32) {
                ab.setVerify("false");
                return mav;
            }

            email = StringEscapeUtils.escapeHtml4(email);
            password = StringEscapeUtils.escapeHtml4(password);
            parameters = new HashMap();
            parameters.put("email", email);
            parameters.put("password", password);

            tmp = RestPostClient.sendReceive(parameters, Constants.URI_FREELANCER_AUTHENTICATION); 
            System.out.println("cjhanclas " + tmp);            
            if (tmp != null && tmp.length() > 0) {
                
                jsonReturn = new JSONObject(tmp);                 
                
                if (jsonReturn.has("email") && jsonReturn.getString("email").equals(email)) {
                    
                    freelancerBasic = new Gson().fromJson(tmp, FreelancerBasic.class);
                    ab.setVerify("true");
                    createSession(freelancerBasic);
                    
                } else {
                    
                    ab.setVerify("false");
                    
                }
                
            } else {
                
                ab.setVerify("false");
                
            }
            
            mav.addObject("json", new JSONObject(ab).toString());            

        } catch (Exception e) {
            logger.error("authentication", e);
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text116");
        }

        return mav;
    }

    //==========================================================================
    private void createSession(FreelancerBasic f) {
        session.setAttribute("logged", "true");
        session.setAttribute("freelancerBasic", f);
    }

}
