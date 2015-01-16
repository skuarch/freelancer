package controllers.application;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.beans.AuthenticationBean;
import model.beans.User;
import model.database.DAO;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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
    private HttpSession session;
    @Autowired
    private AuthenticationBean ab;
    
    
    //==========================================================================
    @RequestMapping(value = {"authentication", "/authentication"}, method = RequestMethod.POST)
    public ModelAndView Authentication(@RequestParam("email") String email, @RequestParam("password") String password,HttpServletResponse response) {        
        
        HashMap parameters = new HashMap();
        User user = null;
        List<User> userList = null;    
        ModelAndView mav = new ModelAndView();
        
        try {            
            
            setHeaderNoChache(response);
            
            mav.setViewName("application/json");                        
            
            if(response == null){
                return mav;
            }
            
            
            if(email == null || email.length() < 1 || !email.contains("@")){
                ab.setVerify("false");
                return mav;
            }
            
            if(password == null || password.length() != 32){
                ab.setVerify("false");
                return mav;
            }
            
            email =  StringEscapeUtils.escapeHtml4(email);
            password =  StringEscapeUtils.escapeHtml4(password);            
     
            parameters.put("email", email);
            parameters.put("password", password);
            userList = new DAO().query(parameters, "getUserByEmail", new User());            
            
            if(userList !=null && userList.size() == 1 ){
                user = userList.get(0);
                ab.setVerify("true");
                createSession(user);
            }else{                
                ab.setVerify("false");
            }
            
            mav.addObject("json", new JSONObject(ab).toString()); 
            
            Thread.sleep(1000);
            
        } catch (Exception e) {
            logger.error("authentication", e);
        }
        
        return mav;
    }
    
    //==========================================================================
    private void createSession(User user){
       session.setAttribute("logged", "true");
       session.setAttribute("user", user);
    }

}
