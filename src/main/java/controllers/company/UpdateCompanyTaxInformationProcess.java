package controllers.company;

import java.util.Locale;
import controllers.application.BaseController;
import java.util.HashMap;
import javax.servlet.http.HttpSession;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.ApplicationUtil;
import model.util.HandlerExceptionUtil;
import model.util.SessionUtil;
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
public class UpdateCompanyTaxInformationProcess extends BaseController {

    private static final Logger logger = Logger.getLogger(UpdateCompanyTaxInformationProcess.class);

    @Autowired
    private MessageSource messageSource;     
    @Autowired
    private HttpSession session;

    //==========================================================================
    @RequestMapping(value = {"/updateCompanyTaxInformationProcess"})
    public ModelAndView methodName(            
            @RequestParam("tax.contact.person.name") String taxContactPersonName,
            @RequestParam("tax.contact.person.lastName") String taxContactPersonLastName,
            @RequestParam("tax.contact.person.email") String taxContactPersonEmail,
            @RequestParam("tax.contact.person.phone") String taxContactPersonPhone,
            @RequestParam("tax.contact.person.gender.id") short taxContactPersonGender,
            @RequestParam("tax.id") String taxId,
            @RequestParam("tax.company.name") String taxCompanyName,
            @RequestParam("address.all") String address,
            @RequestParam("address.country") String addressCountry,
            @RequestParam("address.state") String addressState,
            @RequestParam("address.city") String addressCity,
            @RequestParam("address.zipCode") String addressZipCode,
            Locale locale){
        
        HashMap<String, Object> parameters;
        String json = null;
        ModelAndView mav = new ModelAndView("application/json");
        JSONObject jsono;        
        long companyId;
        
        try {            

            companyId = SessionUtil.getLongParameter(session, "companyId");
            
            parameters = ApplicationUtil.createParametersTaxInformation(
                    companyId,
                    taxContactPersonName,
                    taxContactPersonLastName,
                    taxContactPersonEmail,
                    taxContactPersonPhone,
                    taxContactPersonGender,
                    taxId,
                    taxCompanyName,
                    address,
                    addressCountry,
                    addressState,
                    addressCity,
                    addressZipCode
            );            

            json = RestPostClient.sendReceive(
                    parameters,
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    Constants.URI_COMPANY_UPDATE_TAX_INFORMATION);
            jsono = new JSONObject(json);
            mav.addObject("json", jsono);
            
        } catch (Exception e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text116");
        }

        return mav;

    }

}
