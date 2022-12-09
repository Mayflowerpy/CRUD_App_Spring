package com.spring.crud_app.dao;

import com.spring.crud_app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserDaoImpl(@Qualifier("makeEntityManager") EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public User getById(long id) {
        return  entityManager.find(User.class, id);
    }

    @Override
    public void addUser(User newUser) {
        entityManager.persist(newUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(long id, User userForUpdate) {
        User toUpdate = getById(id);
        toUpdate.setName(userForUpdate.getName());
        toUpdate.setLastName(userForUpdate.getLastName());
        toUpdate.setAge(userForUpdate.getAge());
        toUpdate.setMail(userForUpdate.getMail());
    }

    @Override
    public List<User> getUsersList() {
        TypedQuery<User> query = entityManager
                .createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }
}
