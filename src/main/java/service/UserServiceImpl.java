package service;

import dao.UserDao;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public User getById(long id) {
        return userDao.getById(id);
    }

    @Transactional
    @Override
    public void addUser(User newUser) {
        userDao.addUser(newUser);
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    @Transactional
    @Override
    public void updateUser(long id, User userForUpdate) {
        userDao.updateUser(id, userForUpdate);
    }

    @Transactional
    @Override
    public List<User> getUsersList() {
        return userDao.getUsersList();
    }
}
