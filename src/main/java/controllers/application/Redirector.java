package controllers.application;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class Redirector extends BaseController {

    private static final Logger logger = Logger.getLogger(Redirector.class);
    
    //==========================================================================
    @RequestMapping(value = {"/redirector", "redirector"})
    public ModelAndView redirect(HttpServletRequest request, HttpSession session) {

        ModelAndView modelAndView = null;
        
        try {
            
            String url = request.getParameter("url");
            HashMap<String, String[]> parameters = (HashMap<String, String[]>) request.getParameterMap();

            parameters.entrySet().stream().forEach((entrySet) -> {                
                String key = entrySet.getKey();
                String[] value = entrySet.getValue();
                session.setAttribute(key, value[0]);
                System.out.println("-------redirector key " + key + " value " + value[0]);
            });

            modelAndView = new ModelAndView("redirect:" + url);

        } catch (Exception e) {
            logger.error("Redirector", e);
            modelAndView = new ModelAndView("redirect:systemWelcome.html");
        }

        return modelAndView;
    }

}
