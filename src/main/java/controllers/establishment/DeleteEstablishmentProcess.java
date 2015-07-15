package controllers.establishment;

import controllers.application.BaseController;
import java.util.HashMap;
import model.util.HandlerExceptionUtil;
import org.apache.log4j.Logger;
import java.util.Locale;
import javax.servlet.http.HttpServletResponse;
import model.logic.Constants;
import model.logic.RestPostClient;
import org.json.JSONObject;
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
public class DeleteEstablishmentProcess extends BaseController {

    @Autowired
    private MessageSource messageSource;
    private static final Logger logger = Logger.getLogger(DeleteEstablishmentProcess.class);

    @RequestMapping(value = {"deleteEstablishmentProcess", "/deleteEstablishmentProcess"})
    public ModelAndView createEstablishment(
            @RequestParam long establishmentId,
            Locale locale,
            HttpServletResponse response) {

        ModelAndView mav = getModelAndViewJson();
        HashMap<String, Object> parameters = null;
        String json = null;
        JSONObject jsono = null;        

        try {
            
            //do some validations here            
            setHeaderNoChache(response);

            parameters = new HashMap<>();
            parameters.put("establishmentId", establishmentId);

            json = RestPostClient.sendReceive(
                    parameters,
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    Constants.URI_ESTABLISHMENT_DELETE);
            jsono = new JSONObject(json);
            mav.addObject("json", jsono);
            
        } catch (Exception e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text116");
        }

        return mav;

    }

}
