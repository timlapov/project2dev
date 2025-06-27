package art.lapov.project2dev.repository.interfaces;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<T, K> {
    List<T> findAll();
    Optional<T> findById(K id);
    boolean save(T entity);
    boolean delete(K id);
}
