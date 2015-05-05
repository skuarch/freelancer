package controllers.affiliate;

import controllers.application.BaseController;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import model.logic.Constants;
import model.util.AffiliateUtil;
import model.util.ApplicationUtil;
import model.util.FileUtil;
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
public class UpdateAffiliateBasicInformationProcess extends BaseController {

    private static final Logger logger = Logger.getLogger(UpdateAffiliateBasicInformationProcess.class);
    
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private HttpSession session;    

    //==========================================================================
    @RequestMapping(value = {"updateAffiliateBasicInformationProcess", "/updateAffiliateBasicInformationProcess"})
    public ModelAndView updateAffiliateBasicInformation(            
            @RequestParam("person.name") String personName,
            @RequestParam("person.lastName") String personLastName,
            @RequestParam("person.email") String personEmail,
            @RequestParam("person.phone") String personPhone,            
            @RequestParam("person.gender.id") short personGenderId,
            @RequestParam("brand") String brand,
            @RequestParam String category,
            @RequestParam(value = "logo", required = false) MultipartFile logoMultiPartFile,
            @RequestParam("description") String description,
            Locale locale) {

        HashMap<String, Object> parameters;
        String json;
        ModelAndView mav = null;
        JSONObject jsono;
        File logoFile = null;
        boolean hasLogoFile = false;
        short affiliateId;

        try {

            // transfer file if file is not null
            if (logoMultiPartFile != null) {
                logoFile = FileUtil.transferFileWithOtherName(logoMultiPartFile, Constants.PATH_UPLOADS_TMP,"affiliate_logo");
                hasLogoFile = true;
            }

            affiliateId = SessionUtil.getShortParameter(session, "affiliateId");
            
            parameters = ApplicationUtil.createParameters(
                    affiliateId,
                    personName,
                    personLastName,
                    personEmail,
                    personPhone,                    
                    personGenderId,
                    brand,
                    category,
                    description
            );

            //the request has a file
            if (hasLogoFile) {
                //send parameters and upload the file
                json = AffiliateUtil.sendParametersAndUploadFile(parameters, Constants.URI_AFFILIATE_UPDATE_BASIC_INFORMATION, logoFile, "logoFile");
            } else {
                //only send parameters
                json = AffiliateUtil.sendParameters(parameters, Constants.URI_AFFILIATE_UPDATE_BASIC_INFORMATION);
            }

            mav = new ModelAndView("application/json");
            jsono = new JSONObject(json);
            mav.addObject("json", jsono);

        } catch (Exception e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text116");
        } finally {
            // file is temporal then it should be delete
            FileUtil.deleteFile(logoFile);
        }

        return mav;

    }

}
