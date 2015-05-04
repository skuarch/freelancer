package interceptors;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.logic.Approved;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
public class Session implements HandlerInterceptor {

    private static final Logger logger = Logger.getLogger(Session.class);
    
    //==========================================================================
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {        
        return true;
    }

    //==========================================================================
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView mav) throws Exception {

        try {
            
            if (mav == null) {
                mav = new ModelAndView("application/sessionExpired");
            }

            Object logged = request.getSession().getAttribute("logged");
            String url = request.getRequestURL().toString();
            HashMap<String, String> urls = Approved.getUrls();
            String baseName = FilenameUtils.getBaseName(url);
        //String extension = FilenameUtils.getExtension(url);

            if (baseName.equalsIgnoreCase("")) {
                return;
            }

            if (urls.containsKey(baseName)) {
                return;
            }

            if (logged == null || logged.equals("false")) {
                mav.setViewName("application/sessionExpired");
                return;
            }

            if (!logged.equals("true")) {
                mav.setViewName("application/sessionExpired");
            }
            
        } catch (Exception e) {
            logger.error("SessionInterceptor",e);            
        }

    }

    //==========================================================================
    @Override
    public void afterCompletion(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, Exception excptn) throws Exception {
        //System.out.println("afterCompletation");
    }

} // end class
