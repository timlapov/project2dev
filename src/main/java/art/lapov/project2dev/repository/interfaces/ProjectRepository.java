package art.lapov.project2dev.repository.interfaces;

import art.lapov.project2dev.entity.Project;
import art.lapov.project2dev.entity.Theme;
import art.lapov.project2dev.entity.enums.ProjectStatus;

import java.time.LocalDate;
import java.util.List;

public interface ProjectRepository extends GenericRepository<Project, Long> {
    List<Project> findByStatus(ProjectStatus status);
    List<Project> findByTheme(Theme theme);
    List<Project> findByBudgetRange(Integer minBudget, Integer maxBudget);
    List<Project> findByDeliveryDateBefore(LocalDate date);
    List<Project> findByDeliveryDateAfter(LocalDate date);
}
