package art.lapov.project2dev.repository;

import art.lapov.project2dev.entity.Developer;
import art.lapov.project2dev.repository.interfaces.DeveloperRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.PersistenceException;

import java.util.List;
import java.util.Optional;

public class DeveloperRepositoryImpl extends AbstractRepository<Developer, Long> implements DeveloperRepository {

    public DeveloperRepositoryImpl(EntityManager em) {
        super(em, Developer.class);
    }

    @Override
    public Optional<Developer> findByEmail(String email) {
        try {
            return Optional.ofNullable(em.createQuery( "SELECT d FROM Developer d WHERE d.email = :email",
                            Developer.class)
                    .setParameter("email", email)
                    .getSingleResultOrNull());
        } catch (PersistenceException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }
        return Optional.empty();
    }

}
