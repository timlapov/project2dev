package art.lapov.project2dev.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("DEVELOPER")
public class Developer extends User {
    private String bio;
    private Integer yearsOfExperience;
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "developer_skills",
            joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_title")
    )
    private Set<Skill> skills = new HashSet<>();
    @OneToMany(
            mappedBy = "developer",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Application> applications;


    public Developer() {}

    public Developer(String name, String email, String passwordHash, String bio, Integer yearsOfExperience) {
        super(name, email, passwordHash);
        this.bio = bio;
        this.yearsOfExperience = yearsOfExperience;
    }

    public Developer(Long id, String name, String email, String passwordHash, String bio, Integer yearsOfExperience) {
        super(id, name, email, passwordHash);
        this.bio = bio;
        this.yearsOfExperience = yearsOfExperience;
    }


    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    public void addApplication(Application application) {
        applications.add(application);
        application.setDeveloper(this);
    }

    public void removeApplication(Application application) {
        applications.remove(application);
        application.setDeveloper(null);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "bio='" + bio + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                "} " + super.toString();
    }
}
