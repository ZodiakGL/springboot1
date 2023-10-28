package web.springboot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import web.springboot.model.User;

import java.util.List;


@Repository
public class UserDaoImp implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers () {
        String jpql = "SELECT e FROM User e";
        List<User> users = entityManager.createQuery(jpql, User.class).getResultList();
        return users;
    }

    @Override
    public void addUser(User user) {
        if (user.getId() != 0) {
            entityManager.merge(user);
        } else {
            entityManager.persist(user);
        }
    }

    @Override
    public User getUserById(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public void delete(int id) {
        User userDelete = entityManager.find(User.class, id);
        entityManager.remove(userDelete);
    }
}
