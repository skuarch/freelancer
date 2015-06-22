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
public class CreateCashierFormProccess extends BaseController {

    @Autowired
    private MessageSource messageSource;
    private static final Logger logger = Logger.getLogger(CreateCashierFormProccess.class);
    
    //==========================================================================
    @RequestMapping(value = {"/createCashierFormProccess", "createCashierFormProccess"})
    public ModelAndView createCashier(
            @RequestParam long establishmentId,
            @RequestParam String cashier_name,
            @RequestParam String cashier_lastName,
            @RequestParam String cashier_phone,
            @RequestParam String cashier_email,            
            @RequestParam String cashier_password,            
            @RequestParam long cashier_gender,
            Locale locale){

        ModelAndView mav = getModelAndViewJson();
        JSONObject jsono = null;
        HashMap parameters = null;
        String json = null;
    
        try {            
            
            parameters = ApplicationUtil.createParametersUpdateCashier(
                    establishmentId,
                    cashier_name,
                    cashier_lastName,
                    cashier_phone,
                    cashier_email,
                    cashier_password,
                    cashier_gender);
            
            json  = RestPostClient.sendReceive(
                    parameters, 
                    Constants.API_URL, 
                    Constants.API_FIRST_VERSION, 
                    Constants.URI_CASHIER_CREATE);
            
            jsono = new JSONObject(json);
            mav.addObject("json", jsono.toString());
            
        } catch (Exception e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text114");
        }
    
        return mav;

    }

}
