package model.util;

import java.util.Locale;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
public class HandlerExceptionUtil {    
    
    //==========================================================================
    /**
     * this class doesn't need a public constructor.
     */
    private HandlerExceptionUtil() {
    } // end HandlerExceptionUtil

    //==========================================================================
    public static void alert(ModelAndView mav,MessageSource messageSource,Exception exception,Logger logger,Locale locale) {        
        
        logger.error(" error ", exception);        
        mav.addObject("js","alertify.error(\'"+messageSource.getMessage("text19",null, locale)+"\')");

    } // end handleExceptionAlert
    
    //==========================================================================
    public static void json(ModelAndView mav,MessageSource messageSource,Exception exception,Logger logger,Locale locale) {        
       
        logger.error(" error ", exception);        
        JSONObject jsono = new JSONObject();
        
        if(exception.getMessage() != null){
            jsono.append("error", "error: " + exception.getMessage());
        }else{
            jsono.append("error", messageSource.getMessage("text19",null, locale));
        }
        
        mav.addObject("json",jsono.toString());

    } // end handleExceptionJson
    
    //==========================================================================
    public static void json(ModelAndView mav,MessageSource messageSource,Exception exception,Logger logger,Locale locale,String textNumber) {        
        
        logger.error(" error ", exception);        
        JSONObject jsono = new JSONObject();
        
        if(exception.getMessage() != null){
            jsono.append("error", "error: " + exception.getMessage());
        }else{
            jsono.append("error", messageSource.getMessage(textNumber,null, locale));
        }  
        
        if(mav == null){
            mav = new ModelAndView("aplication/json");
        }
        
        mav.addObject("json",jsono.toString());

    } // end handleExceptionJson

} // end class