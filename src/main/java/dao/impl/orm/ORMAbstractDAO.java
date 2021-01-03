package dao.impl.orm;

import dao.AbstractDAO;
import dao.exception.DAOException;
import dao.impl.orm.session.SessionFactoryProvider;
import entity.IEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public abstract class ORMAbstractDAO<E extends IEntity> extends AbstractDAO<E> {

    private static final SessionFactoryProvider SESSION_FACTORY_PROVIDER = SessionFactoryProvider.getInstance();

    protected abstract String getAllQuery();

    protected abstract Class<E> getEntityClass();

    protected Session openSession() {
        return getSessionFactory().openSession();
    }

    protected SessionFactory getSessionFactory() {
        return SESSION_FACTORY_PROVIDER.getSessionFactory();
    }

    @Override
    public E create(E entity) throws DAOException {
        Transaction transaction = null;
        try (Session session = openSession()) {
            transaction = session.beginTransaction();
            session.persist(entity);
            session.flush();
            transaction.commit();
            return entity;
        } catch (Exception e) {
            LOGGER.error("Unable to save entity: {}", e.getMessage(), e);
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DAOException("Unable to save entity: " + e.getMessage(), e);
        }
    }
    @Override
    public Optional<E> getEntity(int id) throws DAOException {
        try (Session session = openSession()) {
            E entity = session.get(getEntityClass(), id);
            return Optional.ofNullable(entity);
        } catch (Exception e) {
            LOGGER.error("Unable to load entity: {}", e.getMessage(), e);
            throw new DAOException("Unable to load entity: " + e.getMessage(), e);
        }
    }
    @Override
    public List<E> getAll() throws DAOException {
        try (Session session = openSession()) {
            return session.createQuery(getAllQuery()).getResultList();
        } catch (Exception e) {
            LOGGER.error("Unable to load entities: {}", e.getMessage(), e);
            throw new DAOException("Unable to load entities: " + e.getMessage(), e);
        }
    }
    @Override
    public E updateEntity(E entity) throws DAOException {
        try (Session session = openSession()) {
            return (E) session.merge(entity);
        } catch (Exception e) {
            LOGGER.error("Unable to update entity: {}", e.getMessage(), e);
            throw new DAOException("Unable to update entity: " + e.getMessage(), e);
        }
    }
    @Override
    public void deleteEntity(int id) throws DAOException {
        Transaction transaction = null;
        try (Session session = openSession()) {
            transaction = session.beginTransaction();
            session.delete(session.get(getEntityClass(), id));
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.error("Unable to delete entity: {}", e.getMessage(), e);
            throw new DAOException("Unable to delete entity: " + e.getMessage(), e);
        }
    }
}
