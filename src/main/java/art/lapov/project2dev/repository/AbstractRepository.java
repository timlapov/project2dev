package art.lapov.project2dev.repository;

import art.lapov.project2dev.repository.interfaces.GenericRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

import java.util.List;

public abstract class AbstractRepository<T, K> implements GenericRepository<T, K> {
    protected final EntityManager em;
    private final Class<T> entityClass;

    public AbstractRepository(EntityManager em, Class<T> entityClass) {
        this.em = em;
        this.entityClass = entityClass;
    }

    @Override
    public List<T> findAll() {
        try {
            return em.createQuery("FROM " + entityClass.getSimpleName() + " e", entityClass)
                    .getResultList();
        } catch (PersistenceException e) {
            System.err.println(e);
        }
        return null;
    }

    @Override
    public T findById(K id) {
        try {
            return em.find(entityClass, id);
        } catch (PersistenceException e) {
            System.err.println(e);
        }
        return null;
    }

    @Override
    public boolean save(T entity) {
        if (entity != null) {
            try {
                em.getTransaction().begin();
                em.persist(entity);
                em.getTransaction().commit();
                return true;
            } catch (PersistenceException e) {
                System.err.println(e);
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
            }
        }
        return false;
    }

    @Override
    public boolean delete(K id) {
        try {
            em.getTransaction().begin();
            T entity = em.find(entityClass, id);
            if (entity != null) {
                em.remove(entity);
                em.getTransaction().commit();
                return true;
            }
            em.getTransaction().rollback();
        } catch (PersistenceException e) {
            System.err.println(e);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
        return false;
    }

}
