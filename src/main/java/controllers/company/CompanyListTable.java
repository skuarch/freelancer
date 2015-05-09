package controllers.company;

import com.google.gson.Gson;
import controllers.application.BaseController;
import java.util.HashMap;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import model.beans.Company;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.HandlerExceptionUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import model.beans.FreelancerBasic;
import model.util.FreelancerUtil;

/**
 *
 * @author skuarch
 */
@Controller
public class CompanyListTable extends BaseController {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private HttpSession session;
    private static final Logger logger = Logger.getLogger(CompanyListTable.class);
    private FreelancerBasic freelancerBasic = null;

    //==========================================================================
    @RequestMapping(value = {"companyListTable", "/companyListTable"})
    public ModelAndView showTable(Locale locale) {

        ModelAndView mav = null;
        HashMap<String, Object> parameters = null;
        String json = null;
        Company[] companies = null;
        
        try {

            mav = new ModelAndView("company/companyListTable");
            freelancerBasic = FreelancerUtil.getFreelancerBasic(session);
            parameters = FreelancerUtil.createHashMapFreelancerGetCompanies(freelancerBasic.getPersonId());

            json = RestPostClient.sendReceive(
                    parameters,
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    Constants.URI_FREELANCER_GET_COMPANIES
            );
            
            companies = new Gson().fromJson(json, Company[].class);
            mav.addObject("companies", companies);

        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;

    }

}
