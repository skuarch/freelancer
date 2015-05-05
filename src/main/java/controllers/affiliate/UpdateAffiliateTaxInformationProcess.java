package controllers.affiliate;

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
public class UpdateAffiliateTaxInformationProcess extends BaseController {

    private static final Logger logger = Logger.getLogger(UpdateAffiliateTaxInformationProcess.class);
    
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private HttpSession session;    
    
    //==========================================================================
    @RequestMapping(value = {"/updateAffiliateTaxInformationProcess", "updateAffiliateTaxInformationProcess"})
    public ModelAndView updateAffiliateTaxInformation(            
            @RequestParam("tax.contact.person.name") String taxContactPersonName,
            @RequestParam("tax.contact.person.lastName") String taxContactPersonLastName,
            @RequestParam("tax.contact.person.email") String taxContactPersonEmail,
            @RequestParam("tax.contact.person.phone") String taxContactPersonPhone,
            @RequestParam("tax.contact.person.gender.id") short taxContactPersonGender,
            @RequestParam("tax.id") String taxId,
            @RequestParam("tax.company.name") String taxCompanyName,
            @RequestParam("address.all") String address,
            @RequestParam("address.country") String addressCountry,
            @RequestParam("address.city") String addressCity,
            @RequestParam("address.state") String addressState,
            @RequestParam("address.zipCode") String addressZipCode,
            Locale locale
    ){

        HashMap<String, Object> parameters;
        String json;
        ModelAndView mav = null;
        JSONObject jsono;
        short affiliateId;

        try {
            
            affiliateId = SessionUtil.getShortParameter(session, "affiliateId");
            
            parameters = ApplicationUtil.createParameters(
                    affiliateId,
                    taxContactPersonName,
                    taxContactPersonLastName,
                    taxContactPersonEmail,
                    taxContactPersonGender,
                    taxId,
                    taxCompanyName,
                    taxContactPersonPhone,
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
                    Constants.URI_AFFILIATE_UPDATE_TAX_INFORMATION);
            jsono = new JSONObject(json);
            mav = new ModelAndView("application/json");
            mav.addObject("json", jsono);
            
        } catch (Exception e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text116");
        }

        return mav;

    }

}
