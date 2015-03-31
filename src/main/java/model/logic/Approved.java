package model.logic;

import java.util.HashMap;

/**
 *
 * @author skuarch
 */
public class Approved {

    private static final HashMap<String,String> urls = new HashMap<>();
    
    static{    
        urls.put("login", "login");
        urls.put("closeSession", "closeSession");
        urls.put("logout", "logout");
        urls.put("authentication", "authentication");
        urls.put("scriptI18N", "scriptI18N");
        urls.put("logout", "logout");        
        urls.put("oldBrowser", "oldBrowser");        
        urls.put("noscript", "noscript");        
        urls.put("noscript", "noscript");        
        urls.put("notification", "notification");        
        urls.put("srinstaller", "srinstaller");        
        urls.put("error404", "error404");        
        urls.put("welcome", "welcome");        
        urls.put("createFreelancer", "createFreelancer");        
        urls.put("createFreelancerProcess", "createFreelancerProcess");        
        urls.put("redirector", "redirector");        
        //urls.put("testNotifications", "testNotifications");                
        //urls.put("testNotificationsForm", "testNotificationsForm");                
    }

    public static HashMap<String, String> getUrls() {
        return urls;
    }
    
}
