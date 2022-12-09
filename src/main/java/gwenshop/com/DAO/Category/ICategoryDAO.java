package gwenshop.com.DAO.Category;

import gwenshop.com.Entity.Category;

import javax.persistence.EntityManager;
import java.util.List;

public interface ICategoryDAO {
    List<Category> findAll(EntityManager entityManager);
}
