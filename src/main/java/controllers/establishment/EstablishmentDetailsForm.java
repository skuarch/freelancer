package controllers.establishment;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import model.beans.Category;
import model.beans.Establishment;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.ApplicationUtil;
import model.util.HandlerExceptionUtil;
import org.apache.log4j.Logger;
import org.json.JSONArray;
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
public class EstablishmentDetailsForm {

    @Autowired
    private MessageSource messageSource;
    private static final Logger logger = Logger.getLogger(EstablishmentDetailsForm.class);

    //==========================================================================
    @RequestMapping(value = {"/establishmentDetailsForm", "establishmentDetailsForm"})
    public ModelAndView establishmentDetialsForm(@RequestParam long id, Locale locale) {

        ModelAndView mav = new ModelAndView();
        String json = null;
        String jsonCategories = null;
        HashMap parameters = null;
        Establishment establishment = null;
        Category[] categories = null;
        JSONArray jsona = null;
        ArrayList<Category> selectedCategories = null;

        try {

            if (id < 1) {
                mav.setViewName("application/systemWelcome");
                return mav;
            }

            parameters = ApplicationUtil.createParameters(id);
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
            categories = selectCategory(categories, selectedCategories);

            mav = new ModelAndView("establishment/establishmentDetailsForm");
            mav.addObject("id", id);
            mav.addObject("establishment", establishment);
            mav.addObject("categories", categories);

        } catch (IOException | JsonSyntaxException e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;

    }

    //==========================================================================
    private Category[] selectCategory(Category[] categories, ArrayList<Category> selectedCategories) {

        for (Category categorie : categories) {
            selectedCategories.stream()
                    .filter(
                            (selectedCategory) -> 
                                    (categorie.getName().equalsIgnoreCase(selectedCategory.getName()))
                    )
                    .forEach((item) -> {                        
                        categorie.setIsSelected(true);
                    });
        }

        return categories;

    }

}
