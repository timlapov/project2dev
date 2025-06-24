package art.lapov.project2dev.repository;

import art.lapov.project2dev.entity.ProjectOwner;
import art.lapov.project2dev.repository.interfaces.ProjectOwnerRepository;

import java.util.List;

public class ProjectOwnerRepositoryImpl implements ProjectOwnerRepository {
    @Override
    public List<ProjectOwner> findAll() {
        return List.of();
    }

    @Override
    public ProjectOwner findById(Long id) {
        return null;
    }

    @Override
    public boolean save(ProjectOwner entity) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
