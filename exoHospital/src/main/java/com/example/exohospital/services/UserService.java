package com.example.exohospital.services;

import com.example.exohospital.entities.User;
import com.example.exohospital.interfaces.Repository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserService extends BaseService implements Repository<User> {

    public UserService() {
        super();
    }





    @Override
    public boolean create(User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User findById(long id) {
        User user = null;
        try (Session session = sessionFactory.openSession()) {
            user = session.get(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = null;
        try (Session session = sessionFactory.openSession()) {
            Query<User> userQuery = session.createQuery("from User", User.class);
            userList = userQuery.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }
    public boolean getUserByAuth(String username, String password) {
        User user = null;
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("from User where username = :username and password = :password", User.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            user = query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user != null;
    }
}
