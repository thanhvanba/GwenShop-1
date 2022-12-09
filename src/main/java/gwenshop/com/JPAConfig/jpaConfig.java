package gwenshop.com.JPAConfig;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class jpaConfig {
    public static EntityManager getEntityManager(){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPAServletSQL");
        return emFactory.createEntityManager();
    }
}
