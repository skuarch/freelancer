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
    @RequestMapping(value = {"/createFreelancerProcess", "createFreelancerProcess"})
    public ModelAndView createFreelancer(
            @RequestParam("person.email") String personEmail,
            @RequestParam("person.name") String personName,
            @RequestParam("person.lastName") String personLastName,
            @RequestParam("password") String password,
            @RequestParam("person.phone") String personPhone,
            @RequestParam("person.gender.id") short personGenderId,
            @RequestParam("address.all") String address,
            @RequestParam("address.zipCode") String addressZipCode,
            @RequestParam("address.country") String addressCountry,
            @RequestParam("address.city") String addressCity,
            @RequestParam("address.state") String addressState,
            Locale locale
    ) {

        HashMap<String, Object> parameters = null;
        String json = null;
        ModelAndView mav = new ModelAndView("application/json");
        JSONObject jsono = new JSONObject();

        try {
            
            parameters = createHashMapFreelancer(personEmail,
                    personName,
                    personLastName,
                    password,
                    personPhone,
                    personGenderId,
                    address,
                    addressZipCode,
                    addressCountry,
                    addressCity,
                    addressState
            );            
            
            json = RestPostClient.createFreelancer(parameters);
            jsono = new JSONObject(json);
            mav.addObject("json", jsono);

        } catch (Exception e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text116");
        }

        return mav;

    }

    //==========================================================================
    private HashMap<String, Object> createHashMapFreelancer(String personEmail, String personName, String personLastName, String personPassword, String personPhone, short personGenderId, String address, String addressZipCode, String addressCountry, String addressCity, String addressState) {

        HashMap hm = new HashMap();

        try {

            //avoid some html tags
            hm.put("person.email", String.valueOf(personEmail));
            hm.put("person.name", String.valueOf(personName));
            hm.put("person.lastName", String.valueOf(personLastName));
            hm.put("password", String.valueOf(personPassword));
            hm.put("person.phone", String.valueOf(personPhone));
            hm.put("person.gender.id", personGenderId);
            hm.put("address.all", String.valueOf(address));
            hm.put("address.zipCode", Integer.parseInt(addressZipCode));
            hm.put("address.country", String.valueOf(addressCountry));
            hm.put("address.city", String.valueOf(addressCity));
            hm.put("address.state", String.valueOf(addressState));

        } catch (Exception e) {
            throw e;
        }

        return hm;

    }

}
