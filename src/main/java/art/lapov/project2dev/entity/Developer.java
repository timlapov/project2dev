package art.lapov.project2dev.entity;

public class Developer extends User {
    private String bio;
    private Integer yearsOfExperience;

    public Developer() {}

    public Developer(String name, String email, String passwordHash, String bio, Integer yearsOfExperience) {
        super(name, email, passwordHash);
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

    @Override
    public String toString() {
        return "Developer{" +
                "bio='" + bio + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                "} " + super.toString();
    }
}
