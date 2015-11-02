package Core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


/**
 * Created by employee on 10/26/15.
 */

@Transactional
public abstract class BaseDaoimpl<T> implements BaseDao<T> {



    @Autowired
    protected SessionFactory sessionFactory;

    public Session startSession(){
        return sessionFactory.getCurrentSession();
    }

    public abstract List<T> getAll();

    public void save(T object){
        sessionFactory.getCurrentSession().save(object);
    }

    public void delete(T object){
        sessionFactory.getCurrentSession().delete(object);
    }

    public void update(T object){
        sessionFactory.getCurrentSession().saveOrUpdate(object);
    }



}
