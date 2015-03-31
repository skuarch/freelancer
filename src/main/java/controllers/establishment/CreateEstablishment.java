package controllers.establishment;

import com.google.gson.Gson;
import controllers.application.BaseController;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import model.beans.Category;
import model.logic.Constants;
import model.logic.RestPostClient;
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
public class CreateEstablishment extends BaseController {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private HttpSession session;
    private static final Logger logger = Logger.getLogger(CreateEstablishment.class);

    //==========================================================================
    @RequestMapping(value = {"createEstablishment", "/createEstablishment"})
    public ModelAndView createEstablishment(Locale locale) {

        ModelAndView mav = new ModelAndView("establishment/createEstablishment");
        JSONArray jsona = null;
        String tmp = null;
        Category[] categories = null;
        short id = 0;
        short type = 0;

        try {

            type = SessionUtil.getShortParameter(session, "type");            
            
            if(type == Constants.AFFILIATE){
                id = SessionUtil.getShortParameter(session, "affiliateId");
            }else{
                id = SessionUtil.getShortParameter(session, "companyId");
            }            
            
            if (id < 1) {
                mav.setViewName("application/systemWelcome");
                return mav;
            }

            if (type < 1) {
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
            mav.addObject("type", type);

        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }
        
        return mav;

    }

}
