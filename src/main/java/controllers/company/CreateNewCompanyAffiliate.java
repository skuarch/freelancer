package controllers.company;

import com.google.gson.Gson;
import controllers.application.BaseController;
import java.util.Locale;
import model.beans.Category;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.HandlerExceptionUtil;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class CreateNewCompanyAffiliate extends BaseController {

    private static final Logger logger = Logger.getLogger(CreateNewCompanyAffiliate.class);
    
    @Autowired
    MessageSource messageSource;    
    
    //==========================================================================
    @RequestMapping(value = {"createNewCompanyAffiliate","/createNewCompanyAffiliate"})
    public ModelAndView createNewCompanyAffiliate(Locale locale){

        ModelAndView mav = null;
        JSONArray jsona = null;
        String tmp = null;
        Category[] categories = null;

        try {
            
            mav = new ModelAndView("company/createNewCompanyAffliated");
            
            tmp = RestPostClient.sendReceive(
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    Constants.URI_CATEGORY_GET);
            
            jsona = new JSONArray(tmp);
            categories = new Gson().fromJson(jsona.toString(), Category[].class); 
            mav.addObject("categories", categories);
            
        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;

    }

}
