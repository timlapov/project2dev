package art.lapov.project2dev;

import art.lapov.project2dev.entity.Developer;
import art.lapov.project2dev.repository.Database;
import art.lapov.project2dev.repository.DeveloperRepositoryImpl;
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

            System.out.println("Add 3 developers and check the output from the database: ");
            DeveloperRepositoryImpl developerRepository = new DeveloperRepositoryImpl(em);
            Developer dev1 = new Developer(
                    "Timothée",
                    "timlapov@icloud.com",
                    "chdchdsjbcjksanzlxkvbcalj",
                    "Je suis developpeur russe",
                    2);
            Developer dev2 = new Developer(
                    "Patrick",
                    "l.patrick@icloud.com",
                    "chdzlxkvbcalj",
                    "Je suis developpeur français",
                    2);
            Developer dev3 = new Developer(
                    "Nabil",
                    "nabs@icloud.com",
                    "chdc777288vbcalj",
                    "Je suis developpeur du monde",
                    2);
            developerRepository.save(dev1);
            developerRepository.save(dev2);
            developerRepository.save(dev3);
            developerRepository.findAll().forEach(System.out::println);
            System.out.println("\n");


        } catch (Exception e) {
            System.err.println(e);
        } finally {
            Database.closeEntityManager();
        }

    }
}