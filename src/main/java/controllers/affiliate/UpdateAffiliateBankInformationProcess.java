package controllers.affiliate;

import controllers.application.BaseController;
import java.util.HashMap;
import java.util.Locale;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class UpdateAffiliateBankInformationProcess extends BaseController {

    private static final Logger logger = Logger.getLogger(UpdateAffiliateBankInformationProcess.class);
    
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private HttpSession session;    
    
    //==========================================================================
    @RequestMapping(value = {"/updateAffiliateBankInformationProcess", "updateAffiliateBankInformationProcess"})
    public ModelAndView updateAffiliateBankInformation(            
            @RequestParam("owner.account.bank") String ownerAccountBank,
            @RequestParam("bank") String bank,
            @RequestParam("clabe") String clabe,
            @RequestParam("email.notifications") String emailNotifications,
            @RequestParam(value = "file", required = false) MultipartFile file,
            HttpServletResponse response,
            Locale locale) {

        HashMap<String, Object> parameters = null;
        String json = null;
        ModelAndView mav = new ModelAndView("application/json");
        JSONObject jsono;
        short affiliateId;

        try {

            affiliateId = SessionUtil.getShortParameter(session, "affiliateId");
            
            parameters = ApplicationUtil.createParameters(
                    affiliateId,
                    ownerAccountBank,
                    bank,
                    clabe,
                    emailNotifications
            );

            json = RestPostClient.sendReceive(
                    parameters,
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    Constants.URI_AFFILIATE_UPDATE_BANK_INFORMATION);
            jsono = new JSONObject(json);
            mav.addObject("json", jsono);

        } catch (Exception e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text116");
        }

        return mav;

    }

}
