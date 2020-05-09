import model.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.ela");

        Category entities = new Category();
        entities.setActive(true);
        entities.setCreateDataTime(new Date());
        entities.setLastModifiedDataTime(new Date());
        entities.setManualId("id1");
        entities.setName("test");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entities);

        entityManager.getTransaction().commit();
        entityManagerFactory.close();

    }

}

