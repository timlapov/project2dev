package art.lapov.project2dev.entity;

import art.lapov.project2dev.entity.enums.ProjectStatus;

import java.time.LocalDate;

public class Project {
    private Long id;
    private String title;
    private String description;
    private LocalDate createdAt;
    private LocalDate deliveryDate;
    private Integer budget;
    private ProjectStatus status;

    public Project() {}

    public Project(String title, String description, LocalDate createdAt, LocalDate deliveryDate, Integer budget, ProjectStatus status) {
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.deliveryDate = deliveryDate;
        this.budget = budget;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", deliveryDate=" + deliveryDate +
                ", budget=" + budget +
                ", status=" + status +
                '}';
    }
}
