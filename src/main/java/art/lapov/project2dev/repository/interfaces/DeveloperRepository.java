package art.lapov.project2dev.repository.interfaces;

import art.lapov.project2dev.entity.Developer;

import java.util.Optional;

public interface DeveloperRepository extends GenericRepository<Developer, Long> {
    public Optional<Developer> findByEmail(String email);
}
