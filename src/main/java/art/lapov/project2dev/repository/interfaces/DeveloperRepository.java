package art.lapov.project2dev.repository.interfaces;

import art.lapov.project2dev.entity.Developer;

import java.util.List;

public interface DeveloperRepository extends GenericRepository<Developer, Long> {
    public Developer findByEmail(String email);
}
