package controllers.responsable;

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
public class UpdateResponsableFormProccess extends BaseController {

    @Autowired
    private MessageSource messageSource;
    private static final Logger logger = Logger.getLogger(UpdateResponsableFormProccess.class);
    
    //==========================================================================
    @RequestMapping(value = {"/updateResponsableFormProccess","updateResponsableFormProccess"})
    public ModelAndView methodName(
            @RequestParam long id,
            @RequestParam String responsable_name, 
            @RequestParam String responsable_lastName,
            @RequestParam String responsable_phone,
            @RequestParam String responsable_email,
            @RequestParam String responsable_password,
            @RequestParam int responsable_gender,
            Locale locale){

        ModelAndView mav = getModelAndViewJson();
        JSONObject jsono = null;
        HashMap parameters = null;
        String json = null;

        try {

            parameters = ApplicationUtil.createParameters(
                    id,
                    responsable_name,
                    responsable_lastName,
                    responsable_phone,
                    responsable_email,
                    responsable_password,
                    responsable_gender
            );
            json = RestPostClient.sendReceive(parameters, 
                    Constants.API_URL, 
                    Constants.API_FIRST_VERSION, 
                    Constants.URI_RESPONSABLE_UPDATE);
            
            jsono = new JSONObject(json);                        
            mav.addObject("json", jsono);            
            
        } catch (Exception e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text114");
        }

        return mav;

    }

}
