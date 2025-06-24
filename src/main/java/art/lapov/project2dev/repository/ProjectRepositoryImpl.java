package art.lapov.project2dev.repository;

import art.lapov.project2dev.entity.Project;
import art.lapov.project2dev.repository.interfaces.ProjectRepository;

import java.util.List;

public class ProjectRepositoryImpl implements ProjectRepository {
    @Override
    public List<Project> findAll() {
        return List.of();
    }

    @Override
    public Project findById(Long id) {
        return null;
    }

    @Override
    public boolean save(Project entity) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
