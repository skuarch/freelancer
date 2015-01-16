package controllers.application;

import javax.servlet.http.HttpServletResponse;
import model.logic.I18N;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class ScriptI18N extends BaseController {    
    
    @RequestMapping(value = {"scriptI18N","/scripI18N"})
    public ModelAndView scriptI18N(ModelAndView mav,HttpServletResponse response){
        response.setContentType("text/javascript"); 
        mav.setViewName("application/scriptI18N");
        mav.addObject("arrayList", I18N.getArrayList());
        
        return mav;
        
    }
    
}
