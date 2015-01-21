package controllers.application;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
public class BaseController {

    private final static Logger logger = Logger.getLogger(BaseController.class);

    //==========================================================================
    public void setHeaderNoChache(HttpServletResponse response) {

        if (response != null) {
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
        }

    }

    //==========================================================================
    @ExceptionHandler(Throwable.class)
    public ModelAndView handleException(Throwable t, HttpServletRequest request, Exception exception) {
        logger.error("error freelancer", t);
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", exception);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName("application/error");
        return mav;
    }

}
