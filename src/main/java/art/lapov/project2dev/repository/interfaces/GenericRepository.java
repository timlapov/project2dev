package art.lapov.project2dev.repository.interfaces;

import java.util.List;

public interface GenericRepository<T, K> {
    List<T> findAll();
    T findById(K id);
    boolean save(T entity);
    boolean delete(K id);
}
