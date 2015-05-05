package controllers.company;

import com.google.gson.Gson;
import java.util.Locale;
import controllers.application.BaseController;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpSession;
import model.beans.Category;
import model.beans.Company;
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
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author skuarch
 */
@Controller
public class CompanyDetailsForm extends BaseController {

    private static final Logger logger = Logger.getLogger(CompanyDetailsForm.class);

    @Autowired
    private MessageSource messageSource;    
    @Autowired
    private HttpSession session;

    //==========================================================================
    @RequestMapping(value = {"/companyDetailsForm", "companyDetailsForm"})
    public ModelAndView companyDetailsForm(Locale locale){

        ModelAndView mav = new ModelAndView("company/companyDetailsForm");
        Category[] categories = null;
        JSONArray jsona = null;
        ArrayList<Category> selectedCategories = null;
        String jsonCategories = null;
        String json = null;
        HashMap<String, Object> parameters = null;
        long companyId = 0;
        Company company = null;
        
        try {
            
            companyId = SessionUtil.getLongParameter(session, "companyId");
            
            if (companyId < 1) {
                mav = new ModelAndView("application/systemWelcome");                
                return mav;
            }
            
            parameters = ApplicationUtil.createParameters(companyId);            
            json = RestPostClient.sendReceive(
                    parameters,
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    Constants.URI_COMPANY_GET);
           company = new Gson().fromJson(json, Company.class);             
            
            
           jsonCategories = RestPostClient.sendReceive(
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    Constants.URI_CATEGORY_GET);

            jsona = new JSONArray(jsonCategories);
            categories = new Gson().fromJson(jsona.toString(), Category[].class);
            selectedCategories = new ArrayList<>(company.getCategory());
            categories = ApplicationUtil.selectCategory(categories, selectedCategories);            
            
            mav.addObject("categories", categories);
            mav.addObject("company", company);
            
        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;

    }

}
