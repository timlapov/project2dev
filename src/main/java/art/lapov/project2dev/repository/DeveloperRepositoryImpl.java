package art.lapov.project2dev.repository;

import art.lapov.project2dev.entity.Developer;
import art.lapov.project2dev.repository.interfaces.DeveloperRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

import java.util.List;

public class DeveloperRepositoryImpl implements DeveloperRepository {

    private final EntityManager em;

    public DeveloperRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Developer> findAll() {
        try {
            return em.createQuery("FROM Developer d", Developer.class)
                    .getResultList();
        } catch (PersistenceException e) {
            System.err.println(e);
        }
        return null;
    }

    @Override
    public Developer findById(Long id) {
        return null;
    }

    @Override
    public boolean save(Developer entity) {
        if (entity != null) {
            try {
                em.getTransaction().begin();
                em.persist(entity);
                em.getTransaction().commit();
                return true;
            } catch (PersistenceException e) {
                System.err.println(e);
            }
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
