package dao;

import model.User;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

public class UserDAO {

    private StandardServiceRegistry standardServiceRegistry;
    private SessionFactory sessionFactory;

    public UserDAO() {
        standardServiceRegistry = new StandardServiceRegistryBuilder()
                .configure()
                .applySetting(AvailableSettings.CLASSLOADERS, Collections.singletonList(getClass().getClassLoader()))
                .build();
        sessionFactory = new MetadataSources(standardServiceRegistry).buildMetadata().buildSessionFactory();
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
