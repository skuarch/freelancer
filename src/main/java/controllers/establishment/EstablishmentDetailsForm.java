package controllers.establishment;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import model.beans.Category;
import model.beans.Establishment;
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
public class EstablishmentDetailsForm {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private HttpSession session;
    private static final Logger logger = Logger.getLogger(EstablishmentDetailsForm.class);

    //==========================================================================
    @RequestMapping(value = {"/establishmentDetailsForm", "establishmentDetailsForm"})
    public ModelAndView establishmentDetialsForm(Locale locale) {

        ModelAndView mav = new ModelAndView();
        String json = null;
        String jsonCategories = null;
        HashMap parameters = null;
        Establishment establishment = null;
        Category[] categories = null;
        JSONArray jsona = null;
        ArrayList<Category> selectedCategories = null;
        short establishmentId;
        try {

            establishmentId = SessionUtil.getShortParameter(session, "establishmentId");
            
            if (establishmentId < 1) {
                mav.setViewName("application/systemWelcome");
                return mav;
            }

            parameters = ApplicationUtil.createParameters(establishmentId);
            json = RestPostClient.sendReceive(
                    parameters,
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    Constants.URI_ESTABLISHMENT_GET);
            
            jsonCategories = RestPostClient.sendReceive(
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    Constants.URI_CATEGORY_GET);

            jsona = new JSONArray(jsonCategories);
            categories = new Gson().fromJson(jsona.toString(), Category[].class);

            establishment = new Gson().fromJson(json, Establishment.class);
            selectedCategories = new ArrayList<>(establishment.getCategory());
            categories = ApplicationUtil.selectCategory(categories, selectedCategories);

            mav = new ModelAndView("establishment/establishmentDetailsForm");
            mav.addObject("establishmentId", establishmentId);
            mav.addObject("establishment", establishment);
            mav.addObject("categories", categories);
            SessionUtil.setAttribute(session, "responsableId", String.valueOf(establishment.getResponsable().getId()));

        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;
        
    }
    
}
