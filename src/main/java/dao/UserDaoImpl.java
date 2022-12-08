package dao;

import models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    private SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
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

        return null;
    }
}
