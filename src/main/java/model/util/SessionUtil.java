package model.util;

import javax.servlet.http.HttpSession;
import model.beans.User;

/**
 *
 * @author skuarch
 */
public class SessionUtil {

    private SessionUtil() {
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
