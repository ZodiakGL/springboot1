package web.springboot.dao;

import org.springframework.stereotype.Component;
import web.springboot.model.User;


import java.util.List;

@Component
public interface UserDao {
    List<User> getAllUsers();

    void addUser (User user);

    User getUserById(int id);
    void delete (int id);

}
