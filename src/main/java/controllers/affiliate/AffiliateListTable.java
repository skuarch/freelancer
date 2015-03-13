package controllers.affiliate;

import com.google.gson.Gson;
import controllers.application.BaseController;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import model.beans.Affiliate;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.HandlerExceptionUtil;
import org.apache.log4j.Logger;
import org.json.JSONException;
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
public class AffiliateListTable extends BaseController {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private HttpSession session;
    private static final Logger logger = Logger.getLogger(AffiliateListTable.class);
    private FreelancerBasic freelancerBasic = null;

    //==========================================================================
    @RequestMapping(value = {"affiliateListTable", "/affiliateListTable"})
    public ModelAndView showTable(Locale locale) {

        ModelAndView mav = null;
        HashMap<String, Object> parameters = null;
        String json = null;
        Affiliate[] affiliates = null;

        try {

            mav = new ModelAndView("affiliate/affiliateListTable");
            freelancerBasic = FreelancerUtil.getFreelancerBasic(session);
            parameters = FreelancerUtil.createHashMapFreelancerGetAffiliates(freelancerBasic.getId());

            json = RestPostClient.sendReceive(
                    parameters,
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    Constants.URI_FREELANCER_GET_AFFILIATES
            );

            affiliates = new Gson().fromJson(json, Affiliate[].class);
            mav.addObject("affiliates", affiliates);

        } catch (IOException | JSONException e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;

    }

}
