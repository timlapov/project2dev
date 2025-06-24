package art.lapov.project2dev.entity;

public class Skill {
    private String title;
    private String description;

    public Skill() {}

    public Skill(String title, String description) {
        this.title = title;
        this.description = description;
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

    @Override
    public String toString() {
        return "Skill{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
