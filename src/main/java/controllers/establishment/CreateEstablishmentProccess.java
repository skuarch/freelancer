package controllers.establishment;

import controllers.application.BaseController;
import java.util.HashMap;
import model.util.HandlerExceptionUtil;
import org.apache.log4j.Logger;
import java.util.Locale;
import javax.servlet.http.HttpServletResponse;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.ApplicationUtil;
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
public class CreateEstablishmentProccess extends BaseController {

    @Autowired
    private MessageSource messageSource;
    private static final Logger logger = Logger.getLogger(CreateEstablishmentProccess.class);

    @RequestMapping(value = {"createEstablishmentProcess", "/createEstablishmentProcess"})
    public ModelAndView createEstablishment(
            @RequestParam long id,
            @RequestParam long type,
            @RequestParam String establishment_name,
            @RequestParam int[] category,
            @RequestParam String subcategory,
            @RequestParam String establishment_address,
            @RequestParam String country,
            @RequestParam String state,
            @RequestParam String city,
            @RequestParam String zipCode,
            @RequestParam String latitude,
            @RequestParam String longitude,
            @RequestParam String responsable_name,
            @RequestParam String responsable_lastName,
            @RequestParam String responsable_phone,
            @RequestParam String responsable_email,
            @RequestParam String responsable_password,
            @RequestParam String responsable_password2,
            @RequestParam long responsable_gender,
            @RequestParam String cashier_name,
            @RequestParam String cashier_lastName,
            @RequestParam String cashier_phone,
            @RequestParam String cashier_email,
            @RequestParam String cashier_password,
            @RequestParam String cashier_password2,
            @RequestParam long cashier_gender,
            Locale locale,
            HttpServletResponse response) {

        ModelAndView mav = getModelAndViewJson();
        HashMap<String, Object> parameters = null;
        String json = null;
        JSONObject jsono = null;
        String uri = null;

        try {
            
            //do some validations here            
            setHeaderNoChache(response);

            parameters = ApplicationUtil.createParametersEstablishment(
                    id,
                    type,
                    establishment_name,
                    category,
                    subcategory,
                    establishment_address,
                    country,
                    state,
                    city,
                    zipCode,                    
                    latitude,
                    longitude,
                    responsable_name,
                    responsable_lastName,
                    responsable_phone,
                    responsable_email,
                    responsable_password,
                    responsable_password2,
                    responsable_gender,
                    cashier_name,
                    cashier_lastName,
                    cashier_phone,
                    cashier_email,
                    cashier_password,
                    cashier_password2,
                    cashier_gender
            );

            if (type == 1) {
                //affilate
                uri = Constants.URI_AFFILIATE_CREATE_ESTABLISHMENT;
            } else {
                //company
                uri = Constants.URI_COMPANY_CREATE_ESTABLISHMENT;
            }

            json = RestPostClient.sendReceive(
                    parameters,
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    uri);
            jsono = new JSONObject(json);
            mav.addObject("json", jsono);
            
        } catch (Exception e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text116");
        }

        return mav;

    }

}
