package art.lapov.project2dev.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Database {
    private static EntityManager em;

    public static EntityManager getManager() {
        if(em == null) {
            em = Persistence
                    .createEntityManagerFactory("main")
                    .createEntityManager();
        }
        return em;
    }

    public static void reset() {
        em = null;
    }

    public static void closeEntityManager() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}
