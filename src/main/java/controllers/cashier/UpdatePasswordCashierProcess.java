package controllers.cashier;

import controllers.application.BaseController;
import java.util.HashMap;
import java.util.Locale;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.ApplicationUtil;
import model.util.HandlerExceptionUtil;
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
 * @author skuarch
 */
@Controller
public class UpdatePasswordCashierProcess extends BaseController {

    @Autowired
    private MessageSource messageSource;
    private static final Logger logger = Logger.getLogger(UpdatePasswordCashierProcess.class);
    
    //==========================================================================
    @RequestMapping(value = {"updatePasswordCashierProcess", "/updatePasswordCashierProcess"})
    public ModelAndView updateCashierPassword(
            @RequestParam long cashierId, 
            @RequestParam String password1, 
            @RequestParam String password2, 
            Locale locale){

        ModelAndView mav = getModelAndViewJson();
        JSONObject jsono = null;
        HashMap parameters = null;
        String json = null;
        
        try {
            
            if(!password1.equals(password2)){
                jsono = new JSONObject();
                jsono.put("updated", false);                
                mav.addObject("json", jsono);
                return mav;
            }
            
            parameters = ApplicationUtil.createParameters(
                    cashierId,
                    password1, 
                    password2);
            json = RestPostClient.sendReceive(
                    parameters, 
                    Constants.API_URL, 
                    Constants.API_FIRST_VERSION, 
                    Constants.URI_CASHIER_UPDATE_PASSWORD);
            jsono = new JSONObject(json);
            mav.addObject("json", jsono);
            
        } catch (Exception e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text114");
        }        
        
        return mav;
    
    }
    
    
}
