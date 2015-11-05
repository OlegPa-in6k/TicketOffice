package core.dao;

import java.util.List;

/**
 * Created by employee on 10/26/15.
 */
public interface BaseDao<T> {
    void create(T entity);

    T read(int id);

    void update(T entity);

    void delete(T entity);

    List<T> getAll();


}
