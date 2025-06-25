package art.lapov.project2dev.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("PROJECT_OWNER")
public class ProjectOwner extends User {

    private String organization;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Project> projects = new ArrayList<>();

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
