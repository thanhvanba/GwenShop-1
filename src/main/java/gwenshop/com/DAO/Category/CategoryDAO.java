package gwenshop.com.DAO.Category;

import gwenshop.com.Entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CategoryDAO implements ICategoryDAO{
    public List<Category> findAll(EntityManager entityManager){
        String jpql = "SELECT c FROM Category c";
        TypedQuery<Category> query = entityManager.createQuery(jpql, Category.class);
        return query.getResultList();
    }

}
