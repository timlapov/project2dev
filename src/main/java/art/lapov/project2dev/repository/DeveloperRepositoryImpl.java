package art.lapov.project2dev.repository;

import art.lapov.project2dev.entity.Developer;
import art.lapov.project2dev.repository.interfaces.DeveloperRepository;

import java.util.List;

public class DeveloperRepositoryImpl implements DeveloperRepository {
    @Override
    public List<Developer> findAll() {
        return List.of();
    }

    @Override
    public Developer findById(Long id) {
        return null;
    }

    @Override
    public boolean save(Developer entity) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
