package com.spring.crud_app.dao;

import com.spring.crud_app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{


    private EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User getById(long id) {
        return null;
    }

    @Override
    public void addUser(User newUser) {

    }

    @Override
    public void deleteUser(long id) {

    }

    @Override
    public void updateUser(long id, User userForUpdate) {

    }

    @Override
    public List<User> getUsersList() {
        String jpql = "SELECT c FROM User c";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        return query.getResultList();
    }
}
