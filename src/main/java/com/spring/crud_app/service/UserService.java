package com.spring.crud_app.service;

import com.spring.crud_app.models.User;

import java.util.List;

public interface UserService {
    User getById(long id);
    void addUser(User newUser);
    void deleteUser(long id);
    void updateUser(long id, User userForUpdate);
    List<User> getUsersList();
}
