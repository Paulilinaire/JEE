package com.example.exohospital.services;

import com.example.exohospital.entities.CareSheet ;
import com.example.exohospital.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

public class CareSheetService extends BaseService implements Repository<CareSheet>{

    public CareSheetService(){
        super();
    }

    public boolean create(CareSheet careSheet) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(careSheet);
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

//    public boolean update(CareSheet careSheet) {
//        try {
//            session = sessionFactory.openSession();
//            session.beginTransaction();
//            session.update(careSheet);
//            session.getTransaction().commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//    }

//    public boolean delete(CareSheet o) {
//        try {
//            session = sessionFactory.openSession();
//            session.beginTransaction();
//            session.delete(careSheet);
//            session.getTransaction().commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//    }
//

    public CareSheet findById(long id) {
        try {
            CareSheet careSheet = null;
            session = sessionFactory.openSession();
            careSheet = (CareSheet) session.get(CareSheet .class, id);
            return careSheet;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<CareSheet > findAll() {
        try {
            List<CareSheet > careSheetList = null;
            session = sessionFactory.openSession();
            Query<CareSheet > careSheetQuery = session.createQuery("from CareSheet ");
            careSheetList = careSheetQuery.list();
            return careSheetList;
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