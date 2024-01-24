package dao;

import model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class ProductDAO {

    private StandardServiceRegistry standardServiceRegistry;
    private  SessionFactory sessionFactory;

    public ProductDAO() {
        standardServiceRegistry = new StandardServiceRegistryBuilder()
                .configure()
                .applySetting(AvailableSettings.CLASSLOADERS, Collections.singletonList(getClass().getClassLoader()))
                .build();
        sessionFactory = new MetadataSources(standardServiceRegistry).buildMetadata().buildSessionFactory();
    }


    public boolean addProduct(Product product) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return true;
    }



    public void deleteProduct(long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Product productToDelete = session.get(Product.class, id);
            session.delete(productToDelete);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
    }


    public boolean updateProduct(Product product) {
        boolean result = true;
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            result = false;
        }
        return result;
    }



    public List<Product> getAllProducts() {
        List<Product> productList = null;
        try (Session session = sessionFactory.openSession()) {
            Query<Product> productQuery = session.createQuery("from Product", Product.class);
            productList = productQuery.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }


    public Product getProductById(long id) {
        Product product = null;
        try (Session session = sessionFactory.openSession()) {
            product = session.get(Product.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    public List<Product> filterByPrice(double min) {
        List<Product> productList = null;
        Session session = null;

        try {
            if (min >= 0) {
                session = sessionFactory.openSession();

                Query<Product> productQuery = session.createQuery("from Product where price >= :min", Product.class);
                productQuery.setParameter("min", min);

                productList = productQuery.list();
            }
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return productList;
    }


    public List<Product> filterByDate(LocalDate min, LocalDate max) {
        List<Product> productList = null;
        Session session = null;

        try {
            if (min.isBefore(max)) {
                session = sessionFactory.openSession();

                Query<Product> productQuery = session.createQuery("from Product where saleDate >= :min and saleDate <= :max", Product.class);
                productQuery.setParameter("min", min);
                productQuery.setParameter("max", max);

                productList = productQuery.list();
            } else {
                throw new Exception("Erreur de date : min doit être avant max.");
            }
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return productList;
    }


}
