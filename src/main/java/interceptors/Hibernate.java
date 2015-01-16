package interceptors;

import org.hibernate.EmptyInterceptor;
import java.io.Serializable;
import java.util.Iterator;
import org.apache.log4j.Logger;
import org.hibernate.type.Type;

/**
 * 
 * @author skuarch
 */
public class Hibernate extends EmptyInterceptor {

    private static final Logger logger = Logger.getLogger(Hibernate.class);
    private static final long serialVersionUID = 1L;

    //==========================================================================
    @Override
    public void onDelete(Object entity,
            Serializable id,
            Object[] state,
            String[] propertyNames,
            Type[] types) {

        logger.info(entity.getClass() + " deleted");
    }

    //==========================================================================
    @Override
    public boolean onFlushDirty(Object entity,
            Serializable id,
            Object[] currentState,
            Object[] previousState,
            String[] propertyNames,
            Type[] types) {

        logger.info(entity.getClass() + " updated");

        return true;
    }

    //==========================================================================
    @Override
    public boolean onLoad(Object entity,
            Serializable id,
            Object[] state,
            String[] propertyNames,
            Type[] types) {

        // log loading events
        logger.info(entity.getClass() + " loading");
        return true;
    }

    //==========================================================================
    @Override
    public boolean onSave(Object entity,
            Serializable id,
            Object[] state,
            String[] propertyNames,
            Type[] types) {

        logger.info(entity.getClass() + " created");
        return true;

    }

    //==========================================================================
    @Override
    public void preFlush(Iterator iterator) {
        
    }

    //==========================================================================
    @Override
    public void postFlush(Iterator iterator) {
        
    }

}
