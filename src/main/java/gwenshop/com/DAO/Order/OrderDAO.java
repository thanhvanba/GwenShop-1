package gwenshop.com.DAO.Order;

import gwenshop.com.Entity.Order;
import gwenshop.com.Entity.Product;
import gwenshop.com.JPAConfig.jpaConfig;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class OrderDAO {
    public List<Order> findAll(EntityManager entityManager){
        String jpql = "SELECT o FROM Order o";
        TypedQuery<Order> query = entityManager.createQuery(jpql, Order.class);
        return query.getResultList();
    }
}
