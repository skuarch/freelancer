package model.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import model.util.HibernateUtil;
import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

/**
 * Generic Data Access Object, please don't create an object only use a
 * instance. Only used new DAO().method();
 *
 * @author skuarch
 */
public class DAO {

    private Session session = null;

    //==========================================================================
    /**
     * create a instance. for use this class please don't create an object,
     * <br/>
     * only used new DAO().method();
     *
     * @throws Exception
     */
    public DAO() throws Exception {
        startSession();
    } // end DAO

    //==========================================================================
    /**
     * start session with hibernate.
     *
     * @throws HibernateException
     */
    private void startSession() throws HibernateException {

        try {

            session = HibernateUtil.getSessionFactory().openSession();

        } catch (HibernateException he) {
            HibernateUtil.closeSession(session);            
            throw he;
        }
    } // end startSession

    //==========================================================================
    /**
     * save object in database.
     *
     * @param object Object
     * @return long (id)
     * @throws HibernateException
     */
    public long create(Object object) throws HibernateException {

        if (object == null) {
            throw new IllegalArgumentException("the parameter object is null");
        }

        long id = 0;

        try {

            id = (Long) session.save(object);
            session.beginTransaction().commit();

        } catch (HibernateException he) {
            throw he;
        } finally {
            HibernateUtil.closeSession(session);
        }

        return id;

    } // end create

    //==========================================================================
    public <T> ArrayList<T> orderCriteria(T type, int maxResults, String propertyName,String order) {

        ArrayList<T> list = null;

        Criteria criteria = session.createCriteria(type.getClass());
        
        if(order.equalsIgnoreCase("asc")){
            criteria.addOrder(Order.asc(propertyName));
        }else{
            criteria.addOrder(Order.desc(propertyName));
        }
        
        criteria.setMaxResults(maxResults);
        list = new ArrayList(criteria.list());

        return list;
    }

    //==========================================================================
    /**
     * delete object in database.
     *
     * @param object Object
     * @throws HibernateException
     */
    public void delete(Object object) throws HibernateException {

        if (object == null) {
            throw new IllegalArgumentException("the parameter object is null");
        }

        try {

            session.delete(object);
            session.beginTransaction().commit();

        } catch (HibernateException he) {
            throw he;
        } finally {
            HibernateUtil.closeSession(session);
        }
    } // end delete

    //==========================================================================
    /**
     * find object in the data base;
     *
     * @param <T> type
     * @param id long
     * @return Generic Object.
     * @throws HibernateException
     */
    @SuppressWarnings("unchecked")
    public <T> T get(long id, T type) throws HibernateException {

        if (type == null) {
            throw new IllegalArgumentException("the parameter type is null");
        }

        if (id < 1) {
            throw new IllegalArgumentException("the parameter id is less than 1");
        }

        T t = null;

        try {

            t = (T) session.get(type.getClass(), id);
            session.beginTransaction().commit();

        } catch (HibernateException he) {
            throw he;
        } finally {
            HibernateUtil.closeSession(session);
            type = null;
        }

        return t;

    } // end get

    //==========================================================================    
    /**
     * return a list of objects if exists then return a null.
     *
     * @param <T> type
     * @return List or null
     * @throws HibernateException
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> getList(T type) throws HibernateException {

        if (type == null) {
            throw new IllegalArgumentException("the parameter type is null");
        }

        List<T> list = null;

        try {

            list = session.createQuery("from " + type.getClass().getCanonicalName()).list();

        } catch (HibernateException he) {
            throw he;
        } finally {
            HibernateUtil.closeSession(session);
            type = null;
        }

        return list;

    } // end getList

    //==========================================================================    
    /**
     * return an ArrayList of objects if exists then return a null.
     *
     * @param <T> type     
     * @return ArrayList or null
     * @throws HibernateException
     */
    @SuppressWarnings("unchecked")
    public <T> ArrayList<T> getArrayList(T type) throws HibernateException {

        if (type == null) {
            throw new IllegalArgumentException("the parameter type is null");
        }

        ArrayList<T> list = null;

        try {

            list = (ArrayList<T>) session.createQuery("from " + type.getClass().getCanonicalName()).list();

        } catch (HibernateException he) {
            throw he;
        } finally {
            HibernateUtil.closeSession(session);
            type = null;
        }

        return list;

    } // end getList

    //==========================================================================
    /**
     * execute a <code>hql</code> sentence.
     *
     * @param hsql String
     * @return List or null
     * @throws HibernateException
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> hql(String hql, T type) throws HibernateException {

        if (hql == null || hql.length() < 1) {
            throw new IllegalArgumentException("the parameter hql is null");
        }

        if (type == null) {
            throw new IllegalArgumentException("the parameter type is null");
        }

        List<T> list = null;
        Query query = null;

        try {

            session.setCacheMode(CacheMode.IGNORE);
            query = session.createQuery(hql);
            query.setProperties(type);
            query.setCacheable(false);
            list = query.list();
            session.flush();
            session.clear();

        } catch (HibernateException he) {
            throw he;
        } finally {
            HibernateUtil.closeSession(session);
            type = null;
        }

        return list;
    } // end hql

    //==========================================================================
    /**
     * execute a <code>hql</code> sentence.
     *
     * @param hsql String
     * @return List or null
     * @throws HibernateException
     */
    @SuppressWarnings("unchecked")
    public <T> ArrayList<T> hql(T type, String hql) throws HibernateException {

        if (hql == null || hql.length() < 1) {
            throw new IllegalArgumentException("the parameter hql is null");
        }

        if (type == null) {
            throw new IllegalArgumentException("the parameter type is null");
        }

        ArrayList<T> arrayList = null;
        Query query = null;

        try {

            session.setCacheMode(CacheMode.IGNORE);
            query = session.createQuery(hql);
            query.setProperties(type);
            query.setCacheable(false);
            arrayList = (ArrayList<T>) query.list();
            session.flush();
            session.clear();

        } catch (HibernateException he) {
            throw he;
        } finally {
            HibernateUtil.closeSession(session);
            type = null;
        }

        return arrayList;
    } // end hql

    //==========================================================================
    /**
     * execute a <code>hql</code> sentence.
     *
     * @param <T>
     * @param type
     * @param hql
     * @param maxResults
     * @return List or null
     * @throws HibernateException
     */
    @SuppressWarnings("unchecked")
    public <T> ArrayList<T> hql(T type, String hql, int maxResults) throws HibernateException {

        if (hql == null || hql.length() < 1) {
            throw new IllegalArgumentException("the parameter hql is null");
        }

        if (type == null) {
            throw new IllegalArgumentException("the parameter type is null");
        }

        ArrayList<T> arrayList = null;
        Query query = null;

        try {

            session.setCacheMode(CacheMode.IGNORE);
            query = session.createQuery(hql);
            query.setMaxResults(maxResults);
            query.setProperties(type);
            query.setCacheable(false);
            arrayList = (ArrayList<T>) query.list();
            session.flush();
            session.clear();

        } catch (HibernateException he) {
            throw he;
        } finally {
            HibernateUtil.closeSession(session);
            type = null;
        }

        return arrayList;
    } // end hql

    //==========================================================================
    /**
     *
     * @param <T> type
     * @param queryName String
     * @return List or null
     * @throws HibernateException
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> query(String queryName, T type) throws HibernateException {

        if (queryName == null || queryName.length() < 1) {
            throw new NullPointerException("queryName is null or empty");
        }

        if (type == null) {
            throw new NullPointerException("type is null");
        }

        Query query = null;
        List<T> list = null;

        try {

            query = session.getNamedQuery(queryName);
            query.setProperties(type);
            list = query.list();
            session.getTransaction().commit();

        } catch (HibernateException he) {
            throw he;
        } finally {
            HibernateUtil.closeSession(session);
        }

        return list;

    } // end query

    //==========================================================================
    /**
     * @param <T> type
     * @param queryName String
     * @return List or null
     * @throws HibernateException
     */
    public <T> ArrayList<T> query(T type, String queryName) throws HibernateException {

        if (queryName == null || queryName.length() < 1) {
            throw new NullPointerException("queryName is null or empty");
        }

        if (type == null) {
            throw new NullPointerException("type is null");
        }

        Query query = null;
        ArrayList<T> arrayList = null;

        try {

            query = session.getNamedQuery(queryName);            
            query.setProperties(type);            
            arrayList = new ArrayList(query.list());

        } catch (HibernateException he) {
            throw he;
        } finally {
            HibernateUtil.closeSession(session);
        }

        return arrayList;

    } // end query
    
    //==========================================================================
    /**
     * @param <T> type
     * @param queryName String
     * @return List or null
     * @throws HibernateException
     */
    public <T> ArrayList<T> query(T type, String queryName,boolean ignoreCache) throws HibernateException {

        if (queryName == null || queryName.length() < 1) {
            throw new NullPointerException("queryName is null or empty");
        }

        if (type == null) {
            throw new NullPointerException("type is null");
        }

        Query query = null;
        ArrayList<T> arrayList = null;

        try {
            
            query = session.getNamedQuery(queryName);            
            
            if(ignoreCache){
                query.setCacheMode(CacheMode.IGNORE);
            }
            
            query.setProperties(type);            
            arrayList = new ArrayList(query.list());

        } catch (HibernateException he) {
            throw he;
        } finally {
            HibernateUtil.closeSession(session);
        }

        return arrayList;

    } // end query

    //==========================================================================
    /**
     *
     * @param <T> type
     * @param queryName String
     * @param parameters HashMap
     * @return List or null
     * @throws HibernateException
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> query(String queryName, HashMap<String, String> parameters, T type) throws HibernateException {

        if (queryName == null || queryName.length() < 1) {
            throw new NullPointerException("queryName is null or empty");
        }

        if (parameters == null || parameters.size() < 1) {
            throw new NullPointerException("parameters are null or empty");
        }

        if (type == null) {
            throw new NullPointerException("type is null");
        }

        String key = null;
        String value = null;
        Query query = null;
        List<T> list = null;

        try {

            query = session.getNamedQuery(queryName);
            query.setProperties(type);

            for (Map.Entry<String, String> entry : parameters.entrySet()) {
                key = entry.getKey();
                value = entry.getValue();
                query.setString(key, value);
            }

            list = query.list();

        } catch (HibernateException he) {
            throw he;
        } finally {
            HibernateUtil.closeSession(session);
        }

        return list;

    } // end query

    //==========================================================================
    /**
     *
     * @param <T> type
     * @param queryName String
     * @param parameters HashMap
     * @return List or null
     * @throws HibernateException
     */
    @SuppressWarnings("unchecked")
    public <T> ArrayList<T> query(HashMap<String, String> parameters, String queryName, T type) throws HibernateException {

        if (queryName == null || queryName.length() < 1) {
            throw new NullPointerException("queryName is null or empty");
        }

        if (parameters == null || parameters.size() < 1) {
            throw new NullPointerException("parameters are null or empty");
        }

        if (type == null) {
            throw new NullPointerException("type is null");
        }

        String key = null;
        String value = null;
        Query query = null;
        ArrayList<T> arrayList = null;

        try {

            query = session.getNamedQuery(queryName);
            query.setProperties(type);

            for (Map.Entry<String, String> entry : parameters.entrySet()) {
                key = entry.getKey();
                value = entry.getValue();
                query.setString(key, value);
            }

            arrayList = (ArrayList<T>) query.list();

        } catch (HibernateException he) {
            throw he;
        } finally {
            HibernateUtil.closeSession(session);
        }

        return arrayList;

    } // end query

    //==========================================================================
    /**
     *
     * @param <T> type
     * @param queryName String
     * @param parameters ConcurrentHashMap
     * @return List or null
     * @throws HibernateException
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> query(String queryName, ConcurrentHashMap<String, String> parameters, T type) throws HibernateException {

        if (queryName == null || queryName.length() < 1) {
            throw new NullPointerException("parameters are null or empty");
        }

        if (parameters == null || parameters.size() < 1) {
            throw new NullPointerException("parameters are null or empty");
        }

        if (type == null) {
            throw new NullPointerException("type is null");
        }

        String key = null;
        String value = null;
        Query query = null;
        List<T> list = null;

        try {

            query = session.getNamedQuery(queryName);
            query.setProperties(type);

            for (Map.Entry<String, String> entry : parameters.entrySet()) {
                key = entry.getKey();
                value = entry.getValue();
                query.setString(key, value);
            }

            list = query.list();

        } catch (HibernateException he) {
            throw he;
        } finally {
            HibernateUtil.closeSession(session);
        }

        return list;

    } // end query

    //==========================================================================
    /**
     *
     * @param <T> type
     * @param queryName String
     * @param parameters ConcurrentHashMap
     * @return ArrayList<T>
     * @throws HibernateException
     */
    public <T> ArrayList<T> query(String queryName, T type, ConcurrentHashMap<String, String> parameters) throws HibernateException {

        if (queryName == null || queryName.length() < 1) {
            throw new NullPointerException("parameters are null or empty");
        }

        if (parameters == null || parameters.size() < 1) {
            throw new NullPointerException("parameters are null or empty");
        }

        if (type == null) {
            throw new NullPointerException("type is null");
        }

        String key = null;
        String value = null;
        Query query = null;
        ArrayList<T> list = null;

        try {

            query = session.getNamedQuery(queryName);
            query.setProperties(type);

            for (Map.Entry<String, String> entry : parameters.entrySet()) {
                key = entry.getKey();
                value = entry.getValue();
                query.setString(key, value);
            }

            list = new ArrayList(query.list());

        } catch (HibernateException he) {
            throw he;
        } finally {
            HibernateUtil.closeSession(session);
        }

        return list;

    } // end query

    //==========================================================================
    public <T> ArrayList<T> queryLimit(String queryName, T type, int start, int maxResults) throws HibernateException {

        if (queryName == null || queryName.length() < 1) {
            throw new NullPointerException("parameters are null or empty");
        }

        if (start < 0 || maxResults < 0) {
            throw new NullPointerException("parameters are less than 0");
        }

        ArrayList<T> arrayList = null;
        Query query = null;

        try {

            query = session.getNamedQuery(queryName);
            query.setFirstResult(start);
            query.setMaxResults(maxResults);
            query.setProperties(type);
            arrayList = new ArrayList(query.list());

        } catch (HibernateException he) {
            throw he;
        } finally {
            HibernateUtil.closeSession(session);
        }

        return arrayList;

    } // end queryLimit

    //==========================================================================
    public <T> List<T> queryLimit(T type, String queryName, int start, int maxResults) throws HibernateException {

        if (queryName == null || queryName.length() < 1) {
            throw new NullPointerException("parameters are null or empty");
        }

        if (start < 0 || maxResults < 0) {
            throw new NullPointerException("parameters are less than 0");
        }

        List<T> list = null;
        Query query = null;

        try {

            query = session.getNamedQuery(queryName);
            query.setFirstResult(start);
            query.setMaxResults(maxResults);
            query.setProperties(type);
            list = query.list();

        } catch (HibernateException he) {
            throw he;
        } finally {
            HibernateUtil.closeSession(session);
        }

        return list;

    } // end queryLimit

    //==========================================================================
    /**
     * update a object in database.
     *
     * @param object Object
     * @throws HibernateException
     */
    public void update(Object object) throws HibernateException {

        if (object == null) {
            throw new IllegalArgumentException("the parameter object is null");
        }

        try {
            session.update(object);
            session.beginTransaction().commit();
        } catch (HibernateException he) {
            throw he;
        } finally {
            HibernateUtil.closeSession(session);
        }

    } // end update

    //==========================================================================
    /**
     * equivalent to count(*) in sql.
     *
     * @param c Class
     * @return long
     * @throws HibernateException
     */
    public long getTotalRows(Class c) throws HibernateException {

        if (c == null) {
            throw new IllegalArgumentException("class is null");
        }

        long rows = 0;
        Criteria criteria = null;

        try {

            criteria = session.createCriteria(c);
            criteria.setProjection(Projections.rowCount());
            rows = (long) criteria.uniqueResult();

        } catch (HibernateException he) {
            throw he;
        } finally {
            HibernateUtil.closeSession(session);
        }

        return rows;

    } // end getTotalRows

} // end class