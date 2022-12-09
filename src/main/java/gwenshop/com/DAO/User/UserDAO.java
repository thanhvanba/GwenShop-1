package gwenshop.com.DAO.User;

import gwenshop.com.Entity.Customer;
import gwenshop.com.Entity.User;
import gwenshop.com.JPAConfig.jpaConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class UserDAO implements IUserDAO {
    @Override
    public void insert(User user) {
        EntityManager entityManager = jpaConfig.getEntityManager();//Connect Database
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(user);
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void delete(int userId) throws Exception {
        EntityManager entityManager = jpaConfig.getEntityManager();//Connect Database
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String delete_at = dtf.format(now).toString();
        try {
            entityManager.getTransaction().begin();
            User user = entityManager.find(User.class, userId);
            user.setDelete_at(delete_at);
            update(user);
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        EntityManager entityManager = jpaConfig.getEntityManager();//Connect Database
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(user);
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
    }
    @Override
    public User findUser(int id, EntityManager entityManager){
        return entityManager.find(User.class, id);
    }
    @Override
    public List<User> findAll(EntityManager entityManager) {
        String jpql = "SELECT u FROM User u where u.salary <> null";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        return query.getResultList();
    }

    @Override
    public List<Customer> findAllCustomer(EntityManager entityManager){
        String jpql = "SELECT c FROM Customer c";
        TypedQuery<Customer> query = entityManager.createQuery(jpql, Customer.class);
        return query.getResultList();
    }
}
