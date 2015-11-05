package persistence;

import core.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import java.lang.reflect.ParameterizedType;
import java.util.List;


/**
 * Created by employee on 10/26/15.
 */

@Transactional
public abstract class BaseDaoImpl<T> implements BaseDao<T> {



    @Autowired
    protected SessionFactory sessionFactory;

    protected Class<T> entityClass;

    public BaseDaoImpl() {
        Class<T> clazz;
        try {
            clazz = getClassType();
        } catch (Exception e) {
            clazz = null;
        }
        this.entityClass = clazz;
    }

    @SuppressWarnings("unchecked")
    private Class<T> getClassType() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Session startSession(){
        return sessionFactory.getCurrentSession();
    }


    @Override
    public void create(Object entity) {
        startSession().persist(entity);
    }

    @Override
    public T read(int id) {
        return startSession().get(entityClass, id);
    }

    @Override
    public void update(Object entity) {
        startSession().update(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void delete(T entity) {
        startSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll() {
        return startSession().createCriteria(entityClass).list();
    }
}
