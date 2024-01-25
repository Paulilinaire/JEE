package com.example.exohospital.services;

import com.example.exohospital.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserService extends BaseService {

    public UserService() {
        super();
    }


    public void addUser(User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = null;
        try (Session session = sessionFactory.openSession()) {
            Query<User> userQuery = session.createQuery("from User", User.class);
            userList = userQuery.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }


    public User getUserById(long id) {
        User user = null;
        try (Session session = sessionFactory.openSession()) {
            user = session.get(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
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
        return user != null; // returns true if a user is found with the provided username and password, and false otherwise
    }


    public void deleteUser(long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            User userToDelete = session.get(User.class, id);
            session.delete(userToDelete);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
    }
}
