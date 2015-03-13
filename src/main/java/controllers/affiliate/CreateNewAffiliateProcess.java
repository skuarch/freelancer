package controllers.affiliate;

import controllers.application.BaseController;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.beans.FreelancerBasic;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.ApplicationUtil;
import model.util.FreelancerUtil;
import model.util.HandlerExceptionUtil;
import org.apache.log4j.Logger;
import org.json.JSONException;
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
    private static final Logger logger = Logger.getLogger(CreateNewAffiliateProcess.class);

    @RequestMapping(value = {"createNewAffiliateProcess", "/createNewAffiliateProcess"})
    public ModelAndView createNewAffiliate(
            @RequestParam("person.email") String personEmail,
            @RequestParam("person.name") String personName,
            @RequestParam("person.lastName") String personLastName,
            @RequestParam("password") String password,
            @RequestParam("person.phone") String personPhone,
            @RequestParam("person.gender.id") short personGenderId,
            @RequestParam("address.all") String address,
            @RequestParam("address.zipCode") String addressZipCode,
            @RequestParam("address.country") String addressCountry,
            @RequestParam("address.city") String addressCity,
            @RequestParam("address.state") String addressState,
            @RequestParam(value = "file", required = false) MultipartFile file,
            HttpServletResponse response,
            Locale locale) {

        ModelAndView mav = getModelAndViewJson();
        HashMap<String, Object> parameters = null;
        String json = null;
        JSONObject jsono = null;
        FreelancerBasic freelancerBasic = null;

        try {

            //upload file
            if (file != null) {

                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = "/home/skuarch/Documents/";
                File dir = new File(rootPath + File.separator);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + "elArchivo");
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                logger.info("Server File Location="
                        + serverFile.getAbsolutePath());

            }

            setHeaderNoChache(response);
            freelancerBasic = FreelancerUtil.getFreelancerBasic(session);

            parameters = ApplicationUtil.createParameters(personEmail,
                    personName,
                    personLastName,
                    password,
                    personPhone,
                    personGenderId,
                    address,
                    addressZipCode,
                    addressCountry,
                    addressCity,
                    addressState,
                    freelancerBasic.getId()
            );

            json = RestPostClient.sendReceive(
                    parameters,
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    Constants.URI_FREELANCER_CREATE_AFFILIATE);
            jsono = new JSONObject(json);
            mav.addObject("json", jsono);

        } catch (IOException | JSONException e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text116");
        } finally {
            parameters = null;
            freelancerBasic = null;
        }

        return mav;

    }

}
