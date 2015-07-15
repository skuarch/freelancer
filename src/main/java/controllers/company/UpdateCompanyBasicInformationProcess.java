package controllers.company;

import java.util.Locale;
import controllers.application.BaseController;
import java.io.File;
import java.util.HashMap;
import javax.servlet.http.HttpSession;
import model.beans.FreelancerBasic;
import model.logic.Constants;
import model.util.AffiliateUtil;
import model.util.ApplicationUtil;
import model.util.FileUtil;
import model.util.FreelancerUtil;
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
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author skuarch
 */
@Controller
public class UpdateCompanyBasicInformationProcess extends BaseController {

    private static final Logger logger = Logger.getLogger(UpdateCompanyBasicInformationProcess.class);

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private HttpSession session;

    //==========================================================================
    @RequestMapping(value = {"/updateCompanyBasicInformationProcess", "updateCompanyBasicInformationProcess"})
    public ModelAndView methodName(
            //@RequestParam("companyId") long companyId,
            @RequestParam("name") String name,
            @RequestParam("brand") String brand,
            @RequestParam("person.name") String personName,
            @RequestParam("person.lastName") String personLastName,
            @RequestParam("person.gender.id") short personGenderId,
            @RequestParam("person.phone") String personPhone,
            @RequestParam("person.email") String personEmail,
            @RequestParam("category") String category,
            @RequestParam(value = "logo", required = false) MultipartFile logoMultiPartFile,
            @RequestParam("website") String website,
            @RequestParam("facebook") String facebook,
            @RequestParam("description") String description,
            Locale locale) {

        ModelAndView mav = getModelAndViewJson();
        HashMap<String, Object> parameters = null;
        String json = null;
        JSONObject jsono = null;
        FreelancerBasic freelancerBasic = null;
        File logoFile = null;
        boolean hasLogoFile = false;
        short companyId;

        try {

            companyId = SessionUtil.getShortParameter(session, "companyId");
            
            freelancerBasic = FreelancerUtil.getFreelancerBasic(session);

            // transfer file if file is not null
            if (logoMultiPartFile != null) {
                logoFile = FileUtil.transferFileWithOtherName(logoMultiPartFile, Constants.PATH_UPLOADS_TMP, "affiliate_logo");
                hasLogoFile = true;
            }
            
            parameters = ApplicationUtil.createParameters(
                    companyId,
                    name,
                    brand,
                    personName,
                    personLastName,
                    personGenderId,
                    personPhone,
                    personEmail,
                    category,
                    website,
                    facebook,
                    description,
                    freelancerBasic.getId()
            );

            //the request has a file
            if (hasLogoFile) {
                //send parameters and upload the file
                json = AffiliateUtil.sendParametersAndUploadFile(parameters, Constants.URI_COMPANY_UPDATE_BASIC_INFORMATION, logoFile, "logoFile");
            } else {
                //only send parameters
                json = AffiliateUtil.sendParameters(parameters, Constants.URI_COMPANY_UPDATE_BASIC_INFORMATION);
            }

            mav = new ModelAndView("application/json");
            jsono = new JSONObject(json);
            mav.addObject("json", jsono);

        } catch (Exception e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text116");
        }

        return mav;

    }

}
