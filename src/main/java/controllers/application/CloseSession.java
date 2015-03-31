package controllers.application;

import javax.servlet.http.HttpSession;
import model.util.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class CloseSession extends BaseController {

    //==========================================================================
    @RequestMapping(value = {"/closeSession", "closeSession"})
    public ModelAndView closeSession(HttpSession session, Model model) {
        
        ModelAndView mav = null;

        try {

            if(model.containsAttribute("counter")) model.asMap().remove("counter");
            
            if (session != null) {
                SessionUtil.cleanAttributeSession(session, "freelancerBasic");
                session.setAttribute("logged", "false");
                session.invalidate();
                session = null;
            }
            
            mav = new ModelAndView("redirect:logout.html");

        } catch (Exception e) {
            throw e;
        }finally{
            session = null;
        }

        return mav;

    }

}
