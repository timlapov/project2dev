package art.lapov.project2dev;

import art.lapov.project2dev.entity.Developer;
import art.lapov.project2dev.entity.Project;
import art.lapov.project2dev.entity.Theme;
import art.lapov.project2dev.repository.ApplicationRepositoryImpl;
import art.lapov.project2dev.repository.Database;
import art.lapov.project2dev.repository.DataLoader;
import art.lapov.project2dev.repository.DeveloperRepositoryImpl;
import art.lapov.project2dev.repository.ProjectOwnerRepositoryImpl;
import art.lapov.project2dev.repository.ProjectRepositoryImpl;
import art.lapov.project2dev.repository.SkillRepositoryImpl;
import art.lapov.project2dev.repository.ThemeRepositoryImpl;
import art.lapov.project2dev.repository.interfaces.ApplicationRepository;
import art.lapov.project2dev.repository.interfaces.DeveloperRepository;
import art.lapov.project2dev.repository.interfaces.ProjectOwnerRepository;
import art.lapov.project2dev.repository.interfaces.ProjectRepository;
import art.lapov.project2dev.repository.interfaces.SkillRepository;
import art.lapov.project2dev.repository.interfaces.ThemeRepository;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        // Display a welcome message to the console
        System.out.println("*".repeat(100));
        System.out.println("Welcome to Project2Dev!");
        System.out.println("*".repeat(100));

        try {
            // Initialize the EntityManager for database operations
            EntityManager em = Database.getManager();
            System.out.println("DataBase is ready!\n");

            // Initialize various repository implementations with the EntityManager
            SkillRepository skillRepo           = new SkillRepositoryImpl(em);
            ThemeRepository themeRepo           = new ThemeRepositoryImpl(em);
            DeveloperRepository devRepo         = new DeveloperRepositoryImpl(em);
            ProjectOwnerRepository ownerRepo    = new ProjectOwnerRepositoryImpl(em);
            ProjectRepository projRepo          = new ProjectRepositoryImpl(em);
            ApplicationRepository appRepo       = new ApplicationRepositoryImpl(em);

            // Load mock data into the database for demonstration
            System.out.println("Loading mock data...");
            DataLoader loader = new DataLoader(
                    skillRepo, themeRepo, devRepo,
                    ownerRepo, projRepo, appRepo);
            // Execute data loading
            loader.loadData();

            // Display all developers loaded into the system
            System.out.println("\nAll developers:");
            devRepo.findAll().forEach(System.out::println);

            // Display all projects loaded into the system
            System.out.println("\nAll projects:");
            projRepo.findAll().forEach(System.out::println);

            // Search for a specific developer by email and print the result
            System.out.println("\nLooking for a developer by email: michael.brown@email.com");
            System.out.println(devRepo.findByEmail("michael.brown@email.com"));

            // Search for a skill by its ID (String) and print the result
            System.out.println("Looking for a skill by ID: Java");
            System.out.println(skillRepo.findById("Java"));

            // Examples of using ApplicationRepositoryImpl methods
            System.out.println("\n--- ApplicationRepositoryImpl Examples ---");
            // Retrieve the first project and developer for demonstration purposes
            Project firstProject = projRepo.findAll().stream().findFirst().orElse(null);
            Developer firstDeveloper = devRepo.findAll().stream().findFirst().orElse(null);

            if (firstProject != null) {
                // Find and print all applications associated with the first project
                System.out.println("Applications for project: " + firstProject.getTitle());
                appRepo.findByProject(firstProject).forEach(System.out::println);
            } else {
                System.out.println("No projects found to demonstrate findByProject.");
            }

            if (firstDeveloper != null) {
                // Find and print all applications submitted by the first developer
                System.out.println("Applications for developer: " + firstDeveloper.getName());
                appRepo.findByDeveloper(firstDeveloper).forEach(System.out::println);
            } else {
                System.out.println("No developers found to demonstrate findByDeveloper.");
            }

            System.out.println("\n--- ProjectRepositoryImpl Examples ---");
            // Examples of using ProjectRepositoryImpl methods
            // Find and print projects with a specific status (e.g., IN_PROGRESS)
            System.out.println("Projects with status IN_PROGRESS:");
            projRepo.findByStatus(art.lapov.project2dev.entity.enums.ProjectStatus.IN_PROGRESS).forEach(System.out::println);

            // Retrieve the theme "Data Science" for demonstration purposes
            Theme dataScience = themeRepo.findById(3L);
            if (dataScience != null) {
                // Find and print projects associated with the Data Science theme
                System.out.println("Projects with theme: " + dataScience.getName());
                projRepo.findByTheme(dataScience).forEach(System.out::println);
            } else {
                System.out.println("No themes found to demonstrate findByTheme.");
            }

            // Find and print projects within a specific budget range
            System.out.println("Projects with budget between 5000 and 15000:");
            projRepo.findByBudgetRange(5000, 15000).forEach(System.out::println);

            // Find and print projects with a delivery date before a specific date
            System.out.println("Projects with delivery date before 2025-08-31:");
            projRepo.findByDeliveryDateBefore(java.time.LocalDate.of(2025, 8, 31)).forEach(System.out::println);

            // Find and print projects with a delivery date after a specific date
            System.out.println("Projects with delivery date after 2025-09-01:");
            projRepo.findByDeliveryDateAfter(java.time.LocalDate.of(2025, 9, 1)).forEach(System.out::println);

        } catch (Exception e) {
            // Catch and print any exceptions that occur during execution
            System.err.println(e);
        } finally {
            // Ensure the EntityManager is closed to release resources
            Database.closeEntityManager();
        }

    }
}