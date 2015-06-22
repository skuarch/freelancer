package controllers.affiliate;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import model.beans.Affiliate;
import model.beans.Category;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.ApplicationUtil;
import model.util.HandlerExceptionUtil;
import model.util.SessionUtil;
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
public class AffiliateDetailsForm {

    private static final Logger logger = Logger.getLogger(AffiliateDetailsForm.class);
    
    @Autowired
    private MessageSource messageSource;    
    @Autowired
    private HttpSession session;    

    //==========================================================================
    @RequestMapping(value = "affiliateDetailsForm")
    public ModelAndView affiliateDetailsForm(Locale locale) {

        ModelAndView mav = null;
        Affiliate affiliate = null;
        HashMap<String,Object> parameters = null;
        String json = null;
        String jsonCategories = null;
        Category[] categories = null;
        JSONArray jsona = null;
        ArrayList<Category> selectedCategories = null;
        short affiliateId;

        try {

            affiliateId = SessionUtil.getShortParameter(session, "affiliateId");
            
            if (affiliateId < 1) {
                mav = new ModelAndView("application/systemWelcome");                
                return mav;
            }

            mav = new ModelAndView("affiliate/affiliateDetialsForm");
            mav.addObject("affiliateId", affiliateId);
            
            parameters = ApplicationUtil.createParameters(affiliateId);
            json = RestPostClient.sendReceive(
                    parameters, 
                    Constants.API_URL, 
                    Constants.API_FIRST_VERSION, 
                    Constants.URI_AFFILIATE_GET);
            
            affiliate = new Gson().fromJson(json, Affiliate.class);            
            
            jsonCategories = RestPostClient.sendReceive(
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    Constants.URI_CATEGORY_GET);

            jsona = new JSONArray(jsonCategories);
            categories = new Gson().fromJson(jsona.toString(), Category[].class);            
            
            selectedCategories = new ArrayList<>(affiliate.getCategory());
            categories = ApplicationUtil.selectCategory(categories, selectedCategories);
            
            mav.addObject("affiliate", affiliate);  
            mav.addObject("categories", categories);
            
        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;

    }

}
