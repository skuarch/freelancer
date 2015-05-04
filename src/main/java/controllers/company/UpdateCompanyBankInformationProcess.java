package controllers.company;

import java.util.Locale;
import controllers.application.BaseController;
import java.util.HashMap;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.ApplicationUtil;
import model.util.HandlerExceptionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.context.MessageSource;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author skuarch
 */
@Controller
public class UpdateCompanyBankInformationProcess extends BaseController {

    private static final Logger logger = Logger.getLogger(UpdateCompanyBankInformationProcess.class);

    @Autowired
    private MessageSource messageSource;    

    //==========================================================================
    @RequestMapping(value = {"/updateCompanyBankInformationProcess", "updateCompanyBankInformationProcess"})
    public ModelAndView methodName(
            @RequestParam("companyId") long id,
            @RequestParam("ownerAccountBank") String ownerAccountBank,
            @RequestParam("bank") String bank,
            @RequestParam("clabe") String clabe,
            @RequestParam("emailNotifications") String emailNotifications,
            Locale locale){

        ModelAndView mav = getModelAndViewJson();
        HashMap<String, Object> parameters = null;
        String json = null;
        JSONObject jsono = null;        

        try {

            parameters = ApplicationUtil.createParameters(
                    id,
                    ownerAccountBank,
                    bank,
                    clabe,
                    emailNotifications                    
            );            

            json = RestPostClient.sendReceive(parameters,
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    Constants.URI_COMPANY_UPDATE_BANK_INFORMATION);
            jsono = new JSONObject(json);
            mav.addObject("json", jsono);
            
        } catch (Exception e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text116");
        }finally {
            parameters = null;            
        }

        return mav;

    }

}
