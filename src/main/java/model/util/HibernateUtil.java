package model.util;

import interceptors.Hibernate;
import model.logic.StaticContext;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class HibernateUtil {

    private static final Logger logger = Logger.getLogger(HibernateUtil.class);
    private static SessionFactory sessionFactory = null;
    private static ServiceRegistry serviceRegistry = null;
    private static StandardServiceRegistryBuilder serviceRegistryBuilder = null;

    //==========================================================================
    static {
        try {

        Configuration configuration = new Configuration();
        configuration.setInterceptor(new Hibernate());                        
        
        configuration.setProperty(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty(AvailableSettings.DRIVER, "com.mysql.jdbc.Driver");                
        configuration.setProperty(AvailableSettings.ORDER_UPDATES, "true");            
        configuration.setProperty(AvailableSettings.DATASOURCE, "jdbc" + StaticContext.getContext());
        
        /*
        configuration.setProperty(AvailableSettings.URL, "jdbc:mysql://localhost:3306" + StaticContext.getContext());
        configuration.setProperty(AvailableSettings.USER, "root");
        configuration.setProperty(AvailableSettings.PASS, "dragon3s12");
        configuration.setProperty(AvailableSettings.C3P0_MIN_SIZE, "1");
        configuration.setProperty(AvailableSettings.C3P0_MAX_SIZE, "5");
        configuration.setProperty(AvailableSettings.C3P0_TIMEOUT, "1800");
        configuration.setProperty(AvailableSettings.C3P0_MAX_STATEMENTS, "50");  
        */
        configuration.configure();

        serviceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        serviceRegistry = serviceRegistryBuilder.build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (Exception e) {
            try {
                logger.error("HibernateUtil", e);
                throw e;
            } catch (Exception ex) {
                logger.error("HibernateUtil", e);
            }
        }
        
    } 

    //==========================================================================
    public static void closeSession(Session session) {

        if (session != null) {

            if (session.isOpen()) {
                session.close();
            }
        }

    }

    //==========================================================================
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
} // end class