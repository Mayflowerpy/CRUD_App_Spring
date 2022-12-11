package com.spring.crud_app.service;

import com.spring.crud_app.dao.UserDao;
import com.spring.crud_app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
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
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Transactional
    @Override
    public void updateUser(long id, User userForUpdate) {
        userDao.updateUser(id, userForUpdate);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getUsersList() {
        return userDao.getUsersList();
    }
}
