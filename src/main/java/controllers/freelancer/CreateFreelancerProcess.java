package controllers.freelancer;

import controllers.application.BaseController;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import model.logic.RestPostClient;
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
public class CreateFreelancerProcess extends BaseController {    
    
    @Autowired
    private MessageSource messageSource;
    private static final Logger logger = Logger.getLogger(CreateFreelancerProcess.class);    
    
    //==========================================================================
    @RequestMapping(value = {"/createFreelancerProcess","createFreelancerProcess"})
    public ModelAndView createFreelancer(
            @RequestParam("person.email") String personEmail,  
            @RequestParam("person.name") String personName,  
            @RequestParam("person.lastName") String personLastName,              
            @RequestParam("person.password") String personPassword,  
            @RequestParam("person.phone") int personPhone,  
            @RequestParam("person.gender.id") short personGenderId,  
            @RequestParam("address.all") String address,  
            @RequestParam("address.zipCode") int addressZipCode,  
            @RequestParam("address.country") String addressCountry,  
            @RequestParam("address.city") String addressCity,  
            @RequestParam("address.state") String addressState,  
            Locale locale
    ){
    
        HashMap parameters = null;
        String json = null;
        ModelAndView mav = new ModelAndView("application/json");
        JSONObject jsono = new JSONObject();
        
        try {            
            
            parameters = createHashMapFreelancer(personEmail, personName, personLastName, personPassword, personPhone, personGenderId, address, addressZipCode, addressCountry, addressCity, addressState);
            json = RestPostClient.createFreelancer(parameters);            
            jsono = new JSONObject(json);
            mav.addObject("json",jsono);
            
        } catch (IOException | JSONException e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text116");
        }
        
        return mav;
        
    }
    
    //==========================================================================
    private HashMap<String,Object> createHashMapFreelancer(String personEmail, String personName, String personLastName, String personPassword, int personPhone, short personGenderId, String address, int addressZipCode, String addressCountry, String addressCity, String addressState){
    
        HashMap hm = new HashMap();
        hm.put("person.email", String.valueOf(personEmail));
        hm.put("person.name", String.valueOf(personName));
        hm.put("person.lastName", String.valueOf(personLastName));
        hm.put("person.password", String.valueOf(personPassword));
        hm.put("person.phone", personPhone);
        hm.put("person.gender.id",personGenderId);
        hm.put("address.all", String.valueOf(address));        
        hm.put("address.zipCode", addressZipCode);
        hm.put("address.country", String.valueOf(addressCountry));
        hm.put("address.city", String.valueOf(addressCity));
        hm.put("address.state", String.valueOf(addressState));
        
        return hm;
        
    }
    
}
