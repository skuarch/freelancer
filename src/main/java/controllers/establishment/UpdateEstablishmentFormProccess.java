package controllers.establishment;

import controllers.application.BaseController;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.ApplicationUtil;
import model.util.HandlerExceptionUtil;
import org.apache.log4j.Logger;
import org.json.JSONException;
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
public class UpdateEstablishmentFormProccess extends BaseController {

    @Autowired
    private MessageSource messageSource;
    private static final Logger logger = Logger.getLogger(UpdateEstablishmentFormProccess.class);
    
    //==========================================================================
    @RequestMapping(value = {"/updateEstablishmentFormProccess", "updateEstablishmentFormProccess"})
    public ModelAndView methodName(
            @RequestParam long id,
            @RequestParam String name, 
            @RequestParam int[] category,
            @RequestParam String subcategory,
            @RequestParam String address,
            @RequestParam String country,
            @RequestParam String state,
            @RequestParam String city,
            @RequestParam String zipCode,
            Locale locale){
        
        ModelAndView mav = getModelAndViewJson();
        JSONObject jsono = null;
        HashMap parameters = null;
        String json = null;

        try {            
            
            parameters = ApplicationUtil.createParameters(
                    id, 
                    name, 
                    category, 
                    subcategory, 
                    address, 
                    country, 
                    state, 
                    city, 
                    zipCode);
            
            json = RestPostClient.sendReceive(
                    parameters, 
                    Constants.API_URL, 
                    Constants.API_FIRST_VERSION, 
                    Constants.ESTABLISHMENT_UPDATE);
            
            jsono = new JSONObject(json);            
            mav.addObject("json", jsono);            
            
        } catch (IOException | JSONException e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text114");
        }

        return mav;

    }

}
