package Core;

import java.util.List;

/**
 * Created by employee on 10/26/15.
 */
public interface BaseDao<T> {

    void save(T entity);

    void update(T entity);

    void delete(T entity);

    List getAll();


}
