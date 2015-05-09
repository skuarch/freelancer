package controllers.affiliate;

import controllers.application.BaseController;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.beans.FreelancerBasic;
import model.logic.Constants;
import model.util.AffiliateUtil;
import model.util.ApplicationUtil;
import model.util.FileUtil;
import model.util.FreelancerUtil;
import model.util.HandlerExceptionUtil;
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
public class CreateNewAffiliateProcess extends BaseController {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private HttpSession session;
    @Autowired
    ServletContext context;
    private static final Logger logger = Logger.getLogger(CreateNewAffiliateProcess.class);

    //==========================================================================
    @RequestMapping(value = {"createNewAffiliateProcess", "/createNewAffiliateProcess"})
    public ModelAndView createNewAffiliate(
            @RequestParam("person.name") String personName,
            @RequestParam("person.lastName") String personLastName,
            @RequestParam("person.email") String personEmail,
            @RequestParam("person.phone") String personPhone,
            @RequestParam("password") String personPassword,
            @RequestParam("person.gender.id") short personGenderId,
            @RequestParam("brand") String brand,
            @RequestParam String category,
            @RequestParam(value = "logo", required = false) MultipartFile logoMultiPartFile,
            @RequestParam("description") String description,
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
            @RequestParam("owner.account.bank") String ownerAccountBank,
            @RequestParam("bank") String bank,
            @RequestParam("clabe") String clabe,
            @RequestParam("email.notifications") String emailNotifications,
            HttpServletResponse response,
            HttpServletRequest request,
            Locale locale) {

        ModelAndView mav = getModelAndViewJson();
        HashMap<String, Object> parameters = null;
        String json;
        JSONObject jsono;
        FreelancerBasic freelancerBasic;
        File logoFile = null;
        boolean hasLogoFile = false;

        try {

            //basic configuration
            setHeaderNoChache(response);

            // transfer file if file is not null
            if (logoMultiPartFile != null) {
                logoFile = FileUtil.transferFileWithOtherName(logoMultiPartFile, Constants.PATH_UPLOADS_TMP,"affiliate_logo");
                hasLogoFile = true;
            }

            //get freelancer from session, this is who created the affliate
            freelancerBasic = FreelancerUtil.getFreelancerBasic(session);

            //create parameters
            parameters = ApplicationUtil.createParametersAffiliate(
                    personName,
                    personLastName,
                    personEmail,
                    personPhone,
                    personPassword,
                    personGenderId,
                    brand,
                    category,
                    description,
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
                    addressZipCode,
                    ownerAccountBank,
                    bank,
                    clabe,
                    emailNotifications,
                    freelancerBasic.getPersonId()                    
            );

            //the request has a file
            if (hasLogoFile) {
                //send parameters and upload the file
                json = AffiliateUtil.sendParametersAndUploadFile(parameters, Constants.URI_AFFILIATE_CREATE, logoFile, "logoFile");
            } else {
                //only send parameters
                json = AffiliateUtil.sendParameters(parameters, Constants.URI_AFFILIATE_CREATE);
            }

            jsono = new JSONObject(json);
            mav.addObject("json", jsono);

        } catch (Exception e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text116");
        } finally {
            //free some memory            
            freelancerBasic = null;

            // file is temporal then it should be delete
            FileUtil.deleteFile(logoFile);
        }

        return mav;

    }

}
