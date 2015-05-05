package controllers.establishment;

import controllers.application.BaseController;
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
 * @author skuarch
 */
@Controller
public class UpdateEstablishmentFormProccess extends BaseController {

    private static final Logger logger = Logger.getLogger(UpdateEstablishmentFormProccess.class);
    
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private HttpSession session;    
    
    //==========================================================================
    @RequestMapping(value = {"/updateEstablishmentFormProccess", "updateEstablishmentFormProccess"})
    public ModelAndView updateEstablishmentFormProccess(            
            @RequestParam String name, 
            @RequestParam int[] category,
            @RequestParam String subcategory,
            @RequestParam String address,
            @RequestParam String country,
            @RequestParam String state,
            @RequestParam String city,
            @RequestParam String zipCode,
            @RequestParam String latitude,
            @RequestParam String longitude,
            Locale locale){
        
        ModelAndView mav = getModelAndViewJson();
        JSONObject jsono = null;
        HashMap parameters = null;
        String json = null;
        short establishmentId;

        try {            
            
            establishmentId = SessionUtil.getShortParameter(session, "establishmentId");
            
            parameters = ApplicationUtil.createParametersUpdateEstablishment(
                    establishmentId, 
                    name, 
                    category, 
                    subcategory, 
                    address, 
                    country, 
                    state, 
                    city, 
                    zipCode,
                    latitude,
                    longitude);
            
            json = RestPostClient.sendReceive(parameters, 
                    Constants.API_URL, 
                    Constants.API_FIRST_VERSION, 
                    Constants.URI_ESTABLISHMENT_UPDATE);
            
            jsono = new JSONObject(json);            
            mav.addObject("json", jsono);            
            
        } catch (Exception e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text114");
        }

        return mav;

    }

}
