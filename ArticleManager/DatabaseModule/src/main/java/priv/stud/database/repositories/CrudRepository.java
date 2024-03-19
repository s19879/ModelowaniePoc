package priv.stud.database.repositories;

import java.util.List;

public interface CrudRepository<T, ID> {
    T findById(ID id);
    boolean save(T saveObject);
    boolean deleteById(ID id);
    boolean delete(T entity);
    boolean existsById(ID id);
}
