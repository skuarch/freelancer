package controllers.affiliate;

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
public class UpdateAffiliateProccess extends BaseController {

    @Autowired
    private MessageSource messageSource;
    private static final Logger logger = Logger.getLogger(UpdateAffiliateProccess.class);

    //==========================================================================
    @RequestMapping(value = {"updateAffiliateProccess", "/updateAffiliateProccess"})
    public ModelAndView methodName(
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
            @RequestParam("id") long id,
            Locale locale) {

        HashMap<String, Object> parameters = null;
        String json = null;
        ModelAndView mav = new ModelAndView("application/json");
        JSONObject jsono = new JSONObject();

        try {
            
            parameters = ApplicationUtil.createParameters(
                    id,
                    personEmail,
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
            json = RestPostClient.sendReceive(
                    parameters, 
                    Constants.API_URL, 
                    Constants.API_FIRST_VERSION, 
                    Constants.URI_AFFILIATE_UPDATE);            
            jsono = new JSONObject(json);
            mav.addObject("json", jsono);

        } catch (IOException | JSONException e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text116");
        }

        return mav;

    }

}
