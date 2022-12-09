package gwenshop.com.DAO.User;

import gwenshop.com.Entity.Customer;
import gwenshop.com.Entity.User;

import javax.persistence.EntityManager;
import java.util.List;

public interface IUserDAO {
    void insert(User user);

    void delete(int userId) throws Exception;

    void update(User user);

    User findUser(int id, EntityManager entityManager);

    List<User> findAll(EntityManager entityManager);
    List<Customer> findAllCustomer(EntityManager entityManager);
}
