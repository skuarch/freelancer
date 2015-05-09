package controllers.company;

import controllers.application.BaseController;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
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
public class CreateNewCompanyProcess extends BaseController {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private HttpSession session;
    private static final Logger logger = Logger.getLogger(CreateNewCompanyProcess.class);

    //==========================================================================
    @RequestMapping(value = {"createNewCompanyProcess"})
    public ModelAndView createNewCompanyProcess(
            @RequestParam("name") String name,
            @RequestParam("brand") String brand,
            @RequestParam("person.name") String personName,
            @RequestParam("person.lastName") String personLastName,
            @RequestParam("person.gender.id") short personGenderId,
            @RequestParam("person.phone") String personPhone,
            @RequestParam("person.email") String personEmail,
            @RequestParam("category") String category,
            @RequestParam("password") String password,
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
            @RequestParam("address.state") String addressState,
            @RequestParam("address.city") String addressCity,
            @RequestParam("address.zipCode") String addressZipCode,
            @RequestParam("ownerAccountBank") String ownerAccountBank,
            @RequestParam("bank") String bank,
            @RequestParam("clabe") String clabe,
            @RequestParam("emailNotifications") String emailNotifications,
            @RequestParam(value = "file", required = false) MultipartFile file,
            HttpServletResponse response,
            Locale locale) {
        
        ModelAndView mav = getModelAndViewJson();
        HashMap<String, Object> parameters = null;
        String json = null;
        JSONObject jsono = null;
        FreelancerBasic freelancerBasic = null;
        File logoFile = null;
        boolean hasLogoFile = false;

        try {
            
            
            // transfer file if file is not null
            if (logoMultiPartFile != null) {
                logoFile = FileUtil.transferFileWithOtherName(logoMultiPartFile, Constants.PATH_UPLOADS_TMP,"company_logo");
                hasLogoFile = true;
            }

            setHeaderNoChache(response);
            freelancerBasic = FreelancerUtil.getFreelancerBasic(session);

            parameters = ApplicationUtil.createParametersCompany(
                    name,
                    brand,
                    personName,
                    personLastName,
                    personGenderId,
                    personPhone,
                    personEmail,
                    category,
                    password,
                    description,
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
                json = AffiliateUtil.sendParametersAndUploadFile(parameters, Constants.URI_COMPANY_CREATE, logoFile, "logoFile");
            } else {
                //only send parameters
                json = AffiliateUtil.sendParameters(parameters, Constants.URI_COMPANY_CREATE);
            }
            
            jsono = new JSONObject(json);
            mav.addObject("json", jsono);

        } catch (Exception e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text116");
        } finally {
            parameters = null;
            freelancerBasic = null;
        }

        return mav;

    }

}
