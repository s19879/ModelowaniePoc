package priv.stud.database.repositories;

import org.hibernate.Session;
import org.hibernate.Transaction;
import priv.stud.database.utils.DatabaseSession;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

public abstract class AbstractRepository<T, ID> implements CrudRepository<T, ID> {
    protected final Session session = DatabaseSession.getSession();

    protected Class<T> clazz;

    protected AbstractRepository(Class<T> clazz) {
        this.clazz = clazz;
    }
    @Override
    public T findById(ID id) {
        T entity = null;
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            entity = session.get(clazz, (Long) id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        }
        return entity;
    }



    @Override
    public boolean save(T saveObject) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(saveObject);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean deleteById(ID id) {
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            T entity = session.get(clazz, (Long) id);
            if(entity != null){
                session.delete(entity);
                transaction.commit();
                return true;
            }
        } catch (Exception e){
            if(transaction != null)
                transaction.rollback();
        }
        return false;
    }

    @Override
    public boolean delete(T entity) {
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
            return true;
        } catch (Exception e){
            if (transaction != null)
                transaction.rollback();
        }
        return false;
    }

    @Override
    public boolean existsById(ID id) {
        boolean exists = false;
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            exists = session.get(clazz, (Long) id) != null;
            transaction.commit();
        } catch(Exception e){
            if(transaction != null)
                transaction.rollback();
        }
        return exists;
    }

    private Transaction createTransaction(@NotNull Session session){
        Objects.requireNonNull(session, "Session cannot be null");
        return session.beginTransaction();
    }
}
