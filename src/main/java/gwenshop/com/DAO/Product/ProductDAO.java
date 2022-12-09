package gwenshop.com.DAO.Product;

import gwenshop.com.Entity.Product;
import gwenshop.com.Entity.Product_Image;
import gwenshop.com.JPAConfig.jpaConfig;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductDAO implements IProductDAO{
    @Override
    public List<Product> findAll(EntityManager entityManager){
        String jpql = "SELECT p FROM Product p";
        TypedQuery<Product> query = entityManager.createQuery(jpql, Product.class);
        return query.getResultList();
    }

    public void EncodeImage(){

    }
    public void insertImage(){

    }
    @Override
    public List<Product_Image> findProductImages(int id, EntityManager entityManager){
//        EntityManager entityManager = jpaConfig.getEntityManager();
        String jpql = "SELECT p FROM Product_Image p where p.id = '"+id+"'";
        TypedQuery<Product_Image> query = entityManager.createQuery(jpql, Product_Image.class);
        return query.getResultList();
    }

}
