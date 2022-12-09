package gwenshop.com.DAO.Product;

import gwenshop.com.Entity.Product;
import gwenshop.com.Entity.Product_Image;

import javax.persistence.EntityManager;
import java.util.List;

public interface IProductDAO {
    List<Product> findAll(EntityManager entityManager);

    List<Product_Image> findProductImages(int id, EntityManager entityManager);
}
