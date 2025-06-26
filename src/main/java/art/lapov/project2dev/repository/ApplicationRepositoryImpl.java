package art.lapov.project2dev.repository;

import art.lapov.project2dev.entity.Application;
import art.lapov.project2dev.repository.interfaces.ApplicationRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ApplicationRepositoryImpl extends AbstractRepository<Application, Long> implements ApplicationRepository {

    public ApplicationRepositoryImpl(EntityManager em) {
        super(em, Application.class);
    }
}
