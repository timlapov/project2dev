package art.lapov.project2dev.repository;

import art.lapov.project2dev.entity.*;
import art.lapov.project2dev.entity.enums.ApplicationStatus;
import art.lapov.project2dev.entity.enums.ProjectStatus;
import art.lapov.project2dev.repository.interfaces.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class DataLoader {

    private SkillRepository skillRepository;

    private ThemeRepository themeRepository;

    private DeveloperRepository developerRepository;

    private ProjectOwnerRepository projectOwnerRepository;

    private ProjectRepository projectRepository;

    private ApplicationRepository applicationRepository;

    public DataLoader(SkillRepository skillRepository, ThemeRepository themeRepository, DeveloperRepository developerRepository, ProjectOwnerRepository projectOwnerRepository, ProjectRepository projectRepository, ApplicationRepository applicationRepository) {
        this.skillRepository = skillRepository;
        this.themeRepository = themeRepository;
        this.developerRepository = developerRepository;
        this.projectOwnerRepository = projectOwnerRepository;
        this.projectRepository = projectRepository;
        this.applicationRepository = applicationRepository;
    }

    public void loadData() {
        // Load Skills
        List<Skill> skills = loadSkills();

        // Load Themes
        List<Theme> themes = loadThemes();

        // Load Users (Developers and Project Owners)
        List<Developer> developers = loadDevelopers(skills);
        List<ProjectOwner> projectOwners = loadProjectOwners();

        // Load Projects
        List<Project> projects = loadProjects(themes, projectOwners);

        // Load Applications
        loadApplications(developers, projects);
    }

    private List<Skill> loadSkills() {
        List<Skill> skills = Arrays.asList(
                new Skill("Java", "Object-oriented programming language used for enterprise applications"),
                new Skill("Python", "High-level programming language for data science and web development"),
                new Skill("JavaScript", "Dynamic programming language for web development"),
                new Skill("React", "JavaScript library for building user interfaces"),
                new Skill("Spring Boot", "Java framework for building microservices and web applications"),
                new Skill("Node.js", "JavaScript runtime for server-side development"),
                new Skill("PostgreSQL", "Advanced open-source relational database"),
                new Skill("MongoDB", "NoSQL document database"),
                new Skill("Docker", "Containerization platform for application deployment"),
                new Skill("Kubernetes", "Container orchestration platform"),
                new Skill("AWS", "Amazon Web Services cloud platform"),
                new Skill("Git", "Version control system for tracking changes in code"),
                new Skill("HTML/CSS", "Markup and styling languages for web development"),
                new Skill("Angular", "TypeScript-based web application framework"),
                new Skill("Vue.js", "Progressive JavaScript framework for building user interfaces")
        );

        skills.forEach(skillRepository::save);
        return skills;
    }

    private List<Theme> loadThemes() {
        List<Theme> themes = Arrays.asList(
                new Theme("Web Development"),
                new Theme("Mobile Development"),
                new Theme("Data Science"),
                new Theme("Machine Learning"),
                new Theme("DevOps"),
                new Theme("Cloud Computing"),
                new Theme("Cybersecurity"),
                new Theme("E-commerce"),
                new Theme("Healthcare"),
                new Theme("Finance"),
                new Theme("Education"),
                new Theme("Gaming")
        );

        themes.forEach(themeRepository::save);
        return themes;
    }

    private List<Developer> loadDevelopers(List<Skill> skills) {
        List<Developer> developers = Arrays.asList(
                new Developer("John Smith", "john.smith@email.com", "hashedpassword1",
                        "Full-stack developer with 5 years of experience in web development", 5),
                new Developer("Sarah Johnson", "sarah.johnson@email.com", "hashedpassword2",
                        "Frontend specialist focusing on React and modern web technologies", 3),
                new Developer("Michael Brown", "michael.brown@email.com", "hashedpassword3",
                        "Backend developer with expertise in Java and Spring ecosystem", 7),
                new Developer("Emily Davis", "emily.davis@email.com", "hashedpassword4",
                        "Data scientist with experience in Python and machine learning", 4),
                new Developer("David Wilson", "david.wilson@email.com", "hashedpassword5",
                        "DevOps engineer specializing in cloud infrastructure and automation", 6),
                new Developer("Lisa Anderson", "lisa.anderson@email.com", "hashedpassword6",
                        "Mobile developer with experience in both iOS and Android platforms", 4),
                new Developer("James Miller", "james.miller@email.com", "hashedpassword7",
                        "Senior full-stack developer with 8+ years of experience", 8),
                new Developer("Anna Taylor", "anna.taylor@email.com", "hashedpassword8",
                        "Frontend developer passionate about user experience and design", 2)
        );

        // Assign skills to developers
        developers.get(0).setSkills(new HashSet<>(Arrays.asList(skills.get(0), skills.get(2), skills.get(3), skills.get(4))));
        developers.get(1).setSkills(new HashSet<>(Arrays.asList(skills.get(2), skills.get(3), skills.get(12), skills.get(13))));
        developers.get(2).setSkills(new HashSet<>(Arrays.asList(skills.get(0), skills.get(4), skills.get(6), skills.get(8))));
        developers.get(3).setSkills(new HashSet<>(Arrays.asList(skills.get(1), skills.get(7), skills.get(10))));
        developers.get(4).setSkills(new HashSet<>(Arrays.asList(skills.get(8), skills.get(9), skills.get(10), skills.get(11))));
        developers.get(5).setSkills(new HashSet<>(Arrays.asList(skills.get(2), skills.get(3), skills.get(14))));
        developers.get(6).setSkills(new HashSet<>(Arrays.asList(skills.get(0), skills.get(1), skills.get(2), skills.get(4), skills.get(6))));
        developers.get(7).setSkills(new HashSet<>(Arrays.asList(skills.get(2), skills.get(3), skills.get(12), skills.get(14))));

        developers.forEach(developerRepository::save);
        return developers;
    }

    private List<ProjectOwner> loadProjectOwners() {
        List<ProjectOwner> projectOwners = Arrays.asList(
                new ProjectOwner("Robert Johnson", "robert.johnson@techcorp.com", "hashedpassword9", "TechCorp Solutions"),
                new ProjectOwner("Maria Garcia", "maria.garcia@innovate.com", "hashedpassword10", "Innovate Labs"),
                new ProjectOwner("Thomas Lee", "thomas.lee@startup.com", "hashedpassword11", "NextGen Startup"),
                new ProjectOwner("Jennifer White", "jennifer.white@enterprise.com", "hashedpassword12", "Enterprise Systems"),
                new ProjectOwner("Christopher Martin", "chris.martin@digitalagency.com", "hashedpassword13", "Digital Agency Pro"),
                new ProjectOwner("Amanda Thompson", "amanda.thompson@healthtech.com", "hashedpassword14", "HealthTech Innovations")
        );

        projectOwners.forEach(projectOwnerRepository::save);
        return projectOwners;
    }

    private List<Project> loadProjects(List<Theme> themes, List<ProjectOwner> projectOwners) {
        List<Project> projects = Arrays.asList(
                new Project("E-commerce Platform Redesign",
                        "Complete redesign of existing e-commerce platform with modern UI/UX and improved performance",
                        LocalDate.now().minusDays(30), LocalDate.now().plusDays(60), 15000, ProjectStatus.OPEN),
                new Project("Mobile Banking App",
                        "Development of secure mobile banking application for iOS and Android",
                        LocalDate.now().minusDays(20), LocalDate.now().plusDays(90), 25000, ProjectStatus.OPEN),
                new Project("Data Analytics Dashboard",
                        "Create comprehensive analytics dashboard for business intelligence",
                        LocalDate.now().minusDays(15), LocalDate.now().plusDays(45), 12000, ProjectStatus.IN_PROGRESS),
                new Project("Cloud Migration Project",
                        "Migrate legacy systems to AWS cloud infrastructure",
                        LocalDate.now().minusDays(45), LocalDate.now().plusDays(30), 20000, ProjectStatus.IN_PROGRESS),
                new Project("Learning Management System",
                        "Build comprehensive LMS for online education platform",
                        LocalDate.now().minusDays(60), LocalDate.now().minusDays(10), 18000, ProjectStatus.CLOSED),
                new Project("Healthcare Portal",
                        "Patient management system for healthcare providers",
                        LocalDate.now().minusDays(25), LocalDate.now().plusDays(75), 22000, ProjectStatus.OPEN),
                new Project("Cybersecurity Audit Tool",
                        "Automated security scanning and reporting tool",
                        LocalDate.now().minusDays(10), LocalDate.now().plusDays(50), 16000, ProjectStatus.OPEN),
                new Project("Gaming Platform Backend",
                        "Scalable backend infrastructure for multiplayer gaming platform",
                        LocalDate.now().minusDays(5), LocalDate.now().plusDays(80), 30000, ProjectStatus.OPEN)
        );

        // Assign themes and owners to projects
        projects.get(0).setTheme(themes.get(7)); // E-commerce
        projects.get(0).setOwner(projectOwners.get(0));

        projects.get(1).setTheme(themes.get(9)); // Finance
        projects.get(1).setOwner(projectOwners.get(1));

        projects.get(2).setTheme(themes.get(2)); // Data Science
        projects.get(2).setOwner(projectOwners.get(2));

        projects.get(3).setTheme(themes.get(5)); // Cloud Computing
        projects.get(3).setOwner(projectOwners.get(3));

        projects.get(4).setTheme(themes.get(10)); // Education
        projects.get(4).setOwner(projectOwners.get(4));

        projects.get(5).setTheme(themes.get(8)); // Healthcare
        projects.get(5).setOwner(projectOwners.get(5));

        projects.get(6).setTheme(themes.get(6)); // Cybersecurity
        projects.get(6).setOwner(projectOwners.get(0));

        projects.get(7).setTheme(themes.get(11)); // Gaming
        projects.get(7).setOwner(projectOwners.get(1));

        projects.forEach(projectRepository::save);
        return projects;
    }

    private void loadApplications(List<Developer> developers, List<Project> projects) {
        List<Application> applications = Arrays.asList(
                new Application(LocalDateTime.now().minusDays(5),
                        "I'm very interested in this e-commerce project. I have 5 years of experience with React and Node.js.",
                        ApplicationStatus.PENDING),
                new Application(LocalDateTime.now().minusDays(3),
                        "I would love to work on the mobile banking app. I have extensive experience with secure financial applications.",
                        ApplicationStatus.ACCEPTED),
                new Application(LocalDateTime.now().minusDays(8),
                        "Perfect match for my data science skills. I've built similar analytics dashboards before.",
                        ApplicationStatus.PENDING),
                new Application(LocalDateTime.now().minusDays(12),
                        "I'm a DevOps engineer with AWS certification. This cloud migration project fits my expertise perfectly.",
                        ApplicationStatus.ACCEPTED),
                new Application(LocalDateTime.now().minusDays(7),
                        "I have experience building educational platforms and would be great for this LMS project.",
                        ApplicationStatus.REFUSED),
                new Application(LocalDateTime.now().minusDays(2),
                        "Healthcare applications are my specialty. I understand HIPAA compliance and security requirements.",
                        ApplicationStatus.PENDING),
                new Application(LocalDateTime.now().minusDays(4),
                        "Cybersecurity is my passion. I've developed similar audit tools and vulnerability scanners.",
                        ApplicationStatus.PENDING),
                new Application(LocalDateTime.now().minusDays(1),
                        "Gaming backend development is exactly what I've been doing for the past 3 years.",
                        ApplicationStatus.PENDING),
                new Application(LocalDateTime.now().minusDays(6),
                        "I'm interested in the e-commerce project. My frontend skills would be valuable for the UI redesign.",
                        ApplicationStatus.WITHDRAWN),
                new Application(LocalDateTime.now().minusDays(9),
                        "I believe my full-stack experience makes me ideal for the banking application development.",
                        ApplicationStatus.REFUSED)
        );

        // Assign developers and projects to applications
        applications.get(0).setDeveloper(developers.get(0));
        applications.get(0).setProject(projects.get(0));

        applications.get(1).setDeveloper(developers.get(5));
        applications.get(1).setProject(projects.get(1));

        applications.get(2).setDeveloper(developers.get(3));
        applications.get(2).setProject(projects.get(2));

        applications.get(3).setDeveloper(developers.get(4));
        applications.get(3).setProject(projects.get(3));

        applications.get(4).setDeveloper(developers.get(6));
        applications.get(4).setProject(projects.get(4));

        applications.get(5).setDeveloper(developers.get(2));
        applications.get(5).setProject(projects.get(5));

        applications.get(6).setDeveloper(developers.get(4));
        applications.get(6).setProject(projects.get(6));

        applications.get(7).setDeveloper(developers.get(6));
        applications.get(7).setProject(projects.get(7));

        applications.get(8).setDeveloper(developers.get(1));
        applications.get(8).setProject(projects.get(0));

        applications.get(9).setDeveloper(developers.get(7));
        applications.get(9).setProject(projects.get(1));

        applications.forEach(applicationRepository::save);
    }
}
