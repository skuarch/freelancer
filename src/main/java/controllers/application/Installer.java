package controllers.application;

import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import model.beans.User;
import model.database.DAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class Installer extends BaseController {   

    //==========================================================================
    @RequestMapping(value = {"/srinstaller", "srinstaller"})
    public ModelAndView installer(HttpServletResponse response) {

        ModelAndView mav = new ModelAndView("application/installer");

        try {            

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mav;

    }

}
