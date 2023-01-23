package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getCountUsers(Integer count);

    void saveUser(User user);

    List<User> getUsers();

    void deleteUser(long id);

    User show(long id);

    void upDate(User user);
}

