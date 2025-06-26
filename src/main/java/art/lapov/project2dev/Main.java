package art.lapov.project2dev;

import art.lapov.project2dev.entity.Developer;
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

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("*".repeat(100));
        System.out.println("Welcome to Project2Dev!");
        System.out.println("*".repeat(100));

        try {
            EntityManager em = Database.getManager();
            System.out.println("DataBase is ready!\n");

            System.out.println("Loading mock data...");
            SkillRepository skillRepo           = new SkillRepositoryImpl(em);
            ThemeRepository themeRepo           = new ThemeRepositoryImpl(em);
            DeveloperRepository devRepo         = new DeveloperRepositoryImpl(em);
            ProjectOwnerRepository ownerRepo    = new ProjectOwnerRepositoryImpl(em);
            ProjectRepository projRepo          = new ProjectRepositoryImpl(em);
            ApplicationRepository appRepo       = new ApplicationRepositoryImpl(em);
            DataLoader loader = new DataLoader(
                    skillRepo, themeRepo, devRepo,
                    ownerRepo, projRepo, appRepo);
            loader.loadData();

            System.out.println("All developers:");
            devRepo.findAll().forEach(System.out::println);

            System.out.println("All projects:");
            projRepo.findAll().forEach(System.out::println);

            System.out.println("\n");


        } catch (Exception e) {
            System.err.println(e);
        } finally {
            Database.closeEntityManager();
        }

    }
}