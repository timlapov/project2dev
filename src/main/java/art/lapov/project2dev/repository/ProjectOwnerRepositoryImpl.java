package art.lapov.project2dev.repository;

import art.lapov.project2dev.entity.ProjectOwner;
import art.lapov.project2dev.repository.interfaces.ProjectOwnerRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ProjectOwnerRepositoryImpl extends AbstractRepository<ProjectOwner, Long> implements ProjectOwnerRepository {

    public ProjectOwnerRepositoryImpl(EntityManager em) {
        super(em, ProjectOwner.class);
    }

}
