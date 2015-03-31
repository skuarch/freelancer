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
public class UpdateAffiliateBasicInformationProcess extends BaseController {

    @Autowired
    private MessageSource messageSource;
    private static final Logger logger = Logger.getLogger(UpdateAffiliateBasicInformationProcess.class);

    //==========================================================================
    @RequestMapping(value = {"updateAffiliateBasicInformationProcess", "/updateAffiliateBasicInformationProcess"})
    public ModelAndView updateAffiliateBasicInformation (
            @RequestParam("affiliateId") long affiliateId,
            @RequestParam("person.name") String personName,
            @RequestParam("person.lastName") String personLastName,
            @RequestParam("person.email") String personEmail,
            @RequestParam("person.phone") String personPhone,
            @RequestParam("password") String password,
            @RequestParam("person.gender.id") short personGenderId,
            @RequestParam("brand") String brand,
            @RequestParam String category,
            Locale locale) {
        
        HashMap<String, Object> parameters = null;
        String json = null;
        ModelAndView mav = new ModelAndView("application/json");
        JSONObject jsono = new JSONObject();

        try {

            parameters = ApplicationUtil.createParameters(
                    affiliateId,
                    personName,
                    personLastName,
                    personEmail,
                    personPhone,
                    password,
                    personGenderId,
                    brand,
                    category
            );
            json = RestPostClient.sendReceive(
                    parameters,
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    Constants.URI_AFFILIATE_UPDATE_BASIC_INFORMATION);
            jsono = new JSONObject(json);
            mav.addObject("json", jsono);

        } catch (Exception e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text116");
        }

        return mav;

    }

}
