package art.lapov.project2dev.repository.interfaces;

import art.lapov.project2dev.entity.Application;
import art.lapov.project2dev.entity.Developer;
import art.lapov.project2dev.entity.Project;
import art.lapov.project2dev.entity.enums.ApplicationStatus;

import java.util.List;

public interface ApplicationRepository extends GenericRepository<Application, Long> {
    List<Application> findByProject(Project project);
    List<Application> findByDeveloper(Developer developer);
}
