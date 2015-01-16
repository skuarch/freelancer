package servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import model.logic.StaticContext;

/**
 *
 * @author skuarch
 */
@WebListener 
public class GlobalContext implements ServletContextListener {    
    
    //==========================================================================
    public GlobalContext() {        
    }
    
    //==========================================================================
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        StaticContext.setContext(sce.getServletContext().getContextPath());
    }

    //==========================================================================
    @Override
    public void contextDestroyed(ServletContextEvent sce) {        
    }

    
}
