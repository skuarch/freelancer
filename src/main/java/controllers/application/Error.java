package controllers.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author skuarch
 */
@Controller
public class Error {
    
    @RequestMapping("/error")
    public String error(){        
        return "application/error";        
    }
    
}
