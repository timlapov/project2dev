package art.lapov.project2dev.repository;

import art.lapov.project2dev.entity.Application;
import art.lapov.project2dev.entity.Developer;
import art.lapov.project2dev.entity.Project;
import art.lapov.project2dev.repository.interfaces.ApplicationRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Collections;
import java.util.List;

public class ApplicationRepositoryImpl extends AbstractRepository<Application, Long> implements ApplicationRepository {

    public ApplicationRepositoryImpl(EntityManager em) {
        super(em, Application.class);
    }

    @Override
    public List<Application> findByProject(Project project) {
        if (project == null) {
            return Collections.emptyList();
        }
        try {
            TypedQuery<Application> query = em.createQuery(
                    "SELECT a FROM Application a WHERE a.project = :project", Application.class);
            query.setParameter("project", project);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Error finding applications by project: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public List<Application> findByDeveloper(Developer developer) {
        if (developer == null) {
            return Collections.emptyList();
        }
        try {
            TypedQuery<Application> query = em.createQuery(
                    "SELECT a FROM Application a WHERE a.developer = :developer", Application.class);
            query.setParameter("developer", developer);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Error finding applications by developer: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
