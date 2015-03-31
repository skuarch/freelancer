package controllers.company;

import controllers.application.BaseController;
import java.util.Locale;
import model.util.HandlerExceptionUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class CompanyList extends BaseController {
 
    private static final Logger logger = Logger.getLogger(CompanyList.class);
    
    @Autowired
    MessageSource messageSource;    
    
    //==========================================================================
    @RequestMapping(value = {"/companiesList", "companiesList"})
    public ModelAndView affiliatesList(Locale locale){
    
        ModelAndView mav = null;
        
        try {
            
            mav = new ModelAndView("company/companyListContainer");
            
        } catch (Exception e) {            
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }
        
        return mav;
        
    }
    
}
