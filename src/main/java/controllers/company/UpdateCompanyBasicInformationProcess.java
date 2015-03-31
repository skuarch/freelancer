package controllers.company;

import java.util.Locale;
import controllers.application.BaseController;
import java.util.HashMap;
import javax.servlet.http.HttpSession;
import model.beans.FreelancerBasic;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.ApplicationUtil;
import model.util.FreelancerUtil;
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
public class UpdateCompanyBasicInformationProcess extends BaseController {

    private static final Logger logger = Logger.getLogger(UpdateCompanyBasicInformationProcess.class);

    @Autowired
    private MessageSource messageSource;    
    @Autowired
    private HttpSession session;

    //==========================================================================
    @RequestMapping(value = {"/updateCompanyBasicInformationProcess", "updateCompanyBasicInformationProcess"})
    public ModelAndView methodName(
            @RequestParam("companyId") long companyId,
            @RequestParam("name") String name,
            @RequestParam("brand") String brand,
            @RequestParam("person.name") String personName,
            @RequestParam("person.lastName") String personLastName,
            @RequestParam("person.gender.id") short personGenderId,
            @RequestParam("person.phone") String personPhone,
            @RequestParam("person.email") String personEmail,
            @RequestParam("category") String category,
            @RequestParam("password") String password,
            Locale locale){

        ModelAndView mav = getModelAndViewJson();
        HashMap<String, Object> parameters = null;
        String json = null;
        JSONObject jsono = null;
        FreelancerBasic freelancerBasic = null;

        try {
            
           freelancerBasic = FreelancerUtil.getFreelancerBasic(session);

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
                    password,
                    freelancerBasic.getId()
            );
            
            json = RestPostClient.sendReceive(parameters,
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    Constants.URI_COMPANY_UPDATE_BASIC_INFORMATION);
            jsono = new JSONObject(json);
            mav.addObject("json", jsono);
            
        } catch (Exception e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text116");
        }finally{
            parameters = null;
            freelancerBasic = null;
        }

        return mav;

    }

}
