package controllers.affiliate;

import controllers.application.BaseController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.HandlerExceptionUtil;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import model.beans.Freelancer;
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
    private Freelancer freelancer = null;

    //==========================================================================
    @RequestMapping(value = {"affiliateListTable", "/affiliateListTable"})
    public ModelAndView showTable(Locale locale) {

        ModelAndView mav = null;
        HashMap<String, Object> parameters = null;
        String json = null;
        JSONArray jsona = null;
        ArrayList<JSONObject> affiliateList = null;

        try {

            mav = new ModelAndView("affiliate/affiliateListTable");
            freelancer = FreelancerUtil.getFreelancer(session);
            parameters = FreelancerUtil.createHashMapFreelancerGetAffiliates(
                    freelancer.getId()
            );

            json = RestPostClient.sendReceive(
                    parameters,
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    Constants.URI_FREELANCER_GET_AFFILIATES
            );

            jsona = new JSONArray(json);
            affiliateList = new ArrayList<>();

            System.out.println("jsona " + jsona.get(0).toString());

            JSONObject affiliate = new JSONObject(jsona.get(0).toString());
            JSONObject affiliatePerson = affiliate.getJSONObject("person");
            JSONArray establishment = affiliate.getJSONArray("establishment");

            System.out.println("affiliate " + affiliate.toString());
            System.out.println("affiliatePerson " + affiliatePerson.toString());
            System.out.println("establishment " + establishment.toString());

        } catch (IOException | JSONException e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;

    }

}
