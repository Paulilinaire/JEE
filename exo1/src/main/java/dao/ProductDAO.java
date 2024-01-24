package dao;

import model.Product;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class ProductDAO extends IBaseDAO {

    public ProductDAO() {
        super();
    }

    public boolean create(Product o) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public boolean update(Product o) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(o);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public boolean delete(Product o) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    // Other methods with try-catch blocks...

    public boolean deleteByBrand(String brand) {
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("delete Product where brand = :brand");
            query.setParameter("brand", brand);
            session.getTransaction().begin();
            int success = query.executeUpdate();
            session.getTransaction().commit();
            return success > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Product findById(long id) {
        try {
            Product product = null;
            session = sessionFactory.openSession();
            product = (Product) session.get(Product.class, id);
            return product;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<Product> findAll() {
        try {
            List<Product> productList = null;
            session = sessionFactory.openSession();
            Query<Product> productQuery = session.createQuery("from Product");
            productList = productQuery.list();
            return productList;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }


    public void begin() {
        try {
            session = sessionFactory.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void end() {
        try {
            sessionFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
