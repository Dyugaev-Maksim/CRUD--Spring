package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User show(long id) {
        return userDao.getUsers().stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Transactional
    @Override
    public void upDate(User user) {
        userDao.upDate(user);
    }

    @Override
    public List<User> getCountUsers(Integer count) {
        if (count == null)
            count = 10;
        return userDao.getUsers().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }
}
