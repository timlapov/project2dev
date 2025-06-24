package art.lapov.project2dev.entity;

public class ProjectOwner extends User {
    private String organization;

    public ProjectOwner() {}

    public ProjectOwner(String name, String email, String passwordHash, String organization) {
        super(name, email, passwordHash);
        this.organization = organization;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "ProjectOwner{" +
                "organization='" + organization + '\'' +
                "} " + super.toString();
    }
}
