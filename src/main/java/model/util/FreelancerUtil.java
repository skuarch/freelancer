package model.util;

import java.util.HashMap;
import javax.servlet.http.HttpSession;
import model.beans.Freelancer;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 *
 * @author skuarch
 */
public class FreelancerUtil {

    //==========================================================================
    private FreelancerUtil() {
    }

    //==========================================================================
    public static void resetFreelancerSession(HttpSession session, Freelancer freelancer) {

        try {
            if (session != null) {

                Object object = session.getAttribute("freelancer");

                if (object != null) {
                    session.removeAttribute("freelancer");
                    object = null;
                    session.setAttribute("freelancer", freelancer);
                }

            }
        } catch (Exception e) {
            throw e;
        }

    }

    //==========================================================================
    public static HashMap<String, Object> createHashMapFreelancer(Freelancer freelancer) {

        HashMap hm = new HashMap();

        try {

            //avoid some html tags
            hm.put("id", freelancer.getId());
            hm.put("person.email", StringEscapeUtils.escapeHtml4(String.valueOf(freelancer.getEmail())));
            hm.put("person.name", StringEscapeUtils.escapeHtml4(String.valueOf(freelancer.getName())));
            hm.put("person.lastName", StringEscapeUtils.escapeHtml4(String.valueOf(freelancer.getLastName())));
            hm.put("person.phone", StringEscapeUtils.escapeHtml4(String.valueOf(freelancer.getPhone())));
            hm.put("person.gender.id", freelancer.getGender());
            hm.put("address.all", StringEscapeUtils.escapeHtml4(String.valueOf(freelancer.getAddressAll())));
            hm.put("address.zipCode", freelancer.getZipCode());
            hm.put("address.country", StringEscapeUtils.escapeHtml4(String.valueOf(freelancer.getCountry())));
            hm.put("address.city", StringEscapeUtils.escapeHtml4(String.valueOf(freelancer.getCity())));
            hm.put("address.state", StringEscapeUtils.escapeHtml4(String.valueOf(freelancer.getState())));

        } catch (Exception e) {
            throw e;
        }

        return hm;

    }

    //==========================================================================
    public static Freelancer getFreelancer(HttpSession session) {
        Freelancer freelancer = null;
        if (session != null) {
            freelancer = (Freelancer) session.getAttribute("freelancer");
        } else {
            throw new NullPointerException("session is null");
        }
        return freelancer;
    }

}
