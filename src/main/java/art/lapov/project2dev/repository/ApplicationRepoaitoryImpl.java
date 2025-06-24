package art.lapov.project2dev.repository;

import art.lapov.project2dev.entity.Application;
import art.lapov.project2dev.repository.interfaces.ApplicationRepository;

import java.util.List;

public class ApplicationRepoaitoryImpl implements ApplicationRepository {
    @Override
    public List<Application> findAll() {
        return List.of();
    }

    @Override
    public Application findById(Long id) {
        return null;
    }

    @Override
    public boolean save(Application entity) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
