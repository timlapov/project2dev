package art.lapov.project2dev.repository;

import art.lapov.project2dev.entity.Project;
import art.lapov.project2dev.entity.Theme;
import art.lapov.project2dev.entity.enums.ProjectStatus;
import art.lapov.project2dev.repository.interfaces.ProjectRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class ProjectRepositoryImpl extends AbstractRepository<Project, Long> implements ProjectRepository {

    public ProjectRepositoryImpl(EntityManager em) {
        super(em, Project.class);
    }

    @Override
    public List<Project> findByStatus(ProjectStatus status) {
        if (status == null) {
            return Collections.emptyList();
        }
        try {
            TypedQuery<Project> query = em.createQuery(
                    "SELECT p FROM Project p WHERE p.status = :status", Project.class);
            query.setParameter("status", status);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Error finding projects by status: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public List<Project> findByTheme(Theme theme) {
        if (theme == null) {
            return Collections.emptyList();
        }
        try {
            TypedQuery<Project> query = em.createQuery(
                    "SELECT p FROM Project p WHERE p.theme = :theme", Project.class);
            query.setParameter("theme", theme);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Error finding projects by theme: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public List<Project> findByBudgetRange(Integer minBudget, Integer maxBudget) {
        try {
            TypedQuery<Project> query = em.createQuery(
                    "SELECT p FROM Project p WHERE p.budget >= :minBudget AND p.budget <= :maxBudget", Project.class);
            query.setParameter("minBudget", minBudget);
            query.setParameter("maxBudget", maxBudget);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Error finding projects by budget range: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public List<Project> findByDeliveryDateBefore(LocalDate date) {
        if (date == null) {
            return Collections.emptyList();
        }
        try {
            TypedQuery<Project> query = em.createQuery(
                    "SELECT p FROM Project p WHERE p.deliveryDate < :date", Project.class);
            query.setParameter("date", date);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Error finding projects by delivery date before: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public List<Project> findByDeliveryDateAfter(LocalDate date) {
        if (date == null) {
            return Collections.emptyList();
        }
        try {
            TypedQuery<Project> query = em.createQuery(
                    "SELECT p FROM Project p WHERE p.deliveryDate > :date", Project.class);
            query.setParameter("date", date);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Error finding projects by delivery date after: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
