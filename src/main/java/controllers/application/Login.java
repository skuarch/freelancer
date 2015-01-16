package controllers.application;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String login(HttpServletResponse response) {
        setHeaderNoChache(response);
        return "application/login";
    }

}
