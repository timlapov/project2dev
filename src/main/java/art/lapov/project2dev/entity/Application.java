package art.lapov.project2dev.entity;

import art.lapov.project2dev.entity.enums.ApplicationStatus;

import java.time.LocalDateTime;

public class Application {
    private Long id;
    private LocalDateTime appliedAt;
    private String message;
    private ApplicationStatus status;

    public Application() {}

    public Application(LocalDateTime appliedAt, String message, ApplicationStatus status) {
        this.appliedAt = appliedAt;
        this.message = message;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getAppliedAt() {
        return appliedAt;
    }

    public void setAppliedAt(LocalDateTime appliedAt) {
        this.appliedAt = appliedAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", appliedAt=" + appliedAt +
                ", message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
