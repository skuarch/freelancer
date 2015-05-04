package controllers.application;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author skuarch
 */
@Controller
public class Login extends BaseController {

    @Autowired
    private HttpSession session;

    @RequestMapping({"/login", "/Login"})
    public String login(HttpServletResponse response, Model model) {
        setHeaderNoChache(response);
        if (session != null) {
            SessionUtil.cleanAttributeSession(session, "freelancerBasic");
            session.setAttribute("logged", "false");
            session.invalidate();
            session = null;
        }
        return "application/login";
    }

}
