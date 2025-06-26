package art.lapov.project2dev.repository;

import art.lapov.project2dev.entity.Developer;
import art.lapov.project2dev.repository.interfaces.DeveloperRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

import java.util.List;

public class DeveloperRepositoryImpl extends AbstractRepository<Developer, Long> implements DeveloperRepository {

    public DeveloperRepositoryImpl(EntityManager em) {
        super(em, Developer.class);
    }

}
