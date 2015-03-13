package model.util;

import javax.servlet.http.HttpSession;
import model.beans.FreelancerBasic;
import model.beans.User;

/**
 *
 * @author skuarch
 */
public class SessionUtil {

    private SessionUtil() {
    }

    //==========================================================================
    public static FreelancerBasic getFreelancerBasic(HttpSession session) {

        if (session == null) {
            throw new IllegalArgumentException("session is null");
        }

        FreelancerBasic fb = null;

        try {

            fb = (FreelancerBasic) session.getAttribute("freelancerBasic");

        } catch (Exception e) {
            throw e;
        }

        return fb;

    }
    
    //==========================================================================
    public static User getUser(HttpSession session) {

        if (session == null) {
            throw new IllegalArgumentException("session is null");
        }

        User user = null;

        try {

            user = (User) session.getAttribute("user");

        } catch (Exception e) {
            throw e;
        }

        return user;

    }

}
