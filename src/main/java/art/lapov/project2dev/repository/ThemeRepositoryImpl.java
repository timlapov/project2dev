package art.lapov.project2dev.repository;

import art.lapov.project2dev.entity.Theme;
import art.lapov.project2dev.repository.interfaces.ThemeRepository;
import jakarta.persistence.EntityManager;

public class ThemeRepositoryImpl extends AbstractRepository<Theme, Long> implements ThemeRepository {

    public ThemeRepositoryImpl(EntityManager em) {
        super(em, Theme.class);
    }
}
