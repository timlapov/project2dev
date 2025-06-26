package art.lapov.project2dev.repository;

import art.lapov.project2dev.entity.Project;
import art.lapov.project2dev.repository.interfaces.ProjectRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ProjectRepositoryImpl extends AbstractRepository<Project, Long> implements ProjectRepository {

    public ProjectRepositoryImpl(EntityManager em) {
        super(em, Project.class);
    }
}
