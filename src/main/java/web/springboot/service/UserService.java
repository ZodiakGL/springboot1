package web.springboot.service;

import org.springframework.stereotype.Component;
import web.springboot.model.User;

import java.util.List;


@Component
public interface UserService {
    List<User> getAllUsers();

    void addUser(User user);

    User getUserById(int id);

    void delete (int id);
}
