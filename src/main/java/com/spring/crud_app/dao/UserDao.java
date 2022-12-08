package com.spring.crud_app.dao;

import com.spring.crud_app.models.User;

import java.util.List;

public interface UserDao {
    User getById(long id);
    void addUser(User newUser);
    void deleteUser(long id);
    void updateUser(long id, User userForUpdate);
    List<User> getUsersList();
}
