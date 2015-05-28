package hitwh.zcc.CA.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;


public class BaseDao<T>{
    
    @Autowired
    private SessionFactory sf;

    @SuppressWarnings("unchecked")
    public T get(Class<T> entityClazz, Serializable id) {
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
        T result = (T) session.get(entityClazz, id);
        t.commit();
        session.close();
        return result;
    }
    /**方便起见，这里使用的是saveOrUpdate方法*/
    public Serializable save(T entity) {
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
        session.saveOrUpdate(entity);
        t.commit();
        session.close();
        return null;
    }

    public void delete(T entity) {
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
        session.delete(entity);
        t.commit();
        session.close();
    }

    public void delete(Class<T> entityClazz, Serializable id) {
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
        session.createQuery("delete " + 
                entityClazz.getSimpleName() +  " en where en.id = ?a").setParameter("a", id).
                executeUpdate();
        t.commit();
        session.close();
    }

    public List<T> findAll(Class<T> entityClazz) {
        return find("select en from "+ entityClazz.getSimpleName()+" en");
    }

    public long getCount(Class<T> entityClazz) {
        List<?> l = find("select count(*) from " + entityClazz.getSimpleName());
        if (l != null && l.size() == 1 ){
            return (long)l.get(0);
        }
        return 0;
    }

    @SuppressWarnings("unchecked")
    public List<T> find(String hql){
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
        List<T> result = session.createQuery(hql).list();
        t.commit();
        session.close();
        return result;    
    }
    
    /**
     * @return the sf
     */
    public SessionFactory getSf() {
        return sf;
    }

    /**
     * @param sf the sf to set
     */
    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

}
