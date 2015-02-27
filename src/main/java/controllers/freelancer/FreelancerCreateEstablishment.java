package controllers.freelancer;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import controllers.application.BaseController;
import java.io.IOException;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import model.beans.Category;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.HandlerExceptionUtil;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class FreelancerCreateEstablishment extends BaseController {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private HttpSession session;
    private static final Logger logger = Logger.getLogger(FreelancerCreateEstablishment.class);

    //==========================================================================
    @RequestMapping(value = {"createEstablishment", "/createEstablishment"})
    public ModelAndView createEstablishment(@RequestParam long id, Locale locale) {

        ModelAndView mav = new ModelAndView("establishment/createEstablishment");        
        JSONArray jsona = null;
        String tmp = null;
        Category[] categories = null;

        try {

            if (id < 1) {
                mav.setViewName("application/systemWelcome");
                return mav;
            }
            
            tmp = RestPostClient.sendReceive(
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    Constants.URI_CATEGORY_GET);
            jsona = new JSONArray(tmp);
            categories = new Gson().fromJson(jsona.toString(), Category[].class);            
            mav.addObject("categories", categories);
            mav.addObject("id", id);
            
        } catch (IOException | JSONException | JsonSyntaxException e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;

    }

}
