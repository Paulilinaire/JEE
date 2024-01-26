package com.example.exohospital.services;

import com.example.exohospital.entities.Prescription ;
import com.example.exohospital.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

public class PrescriptionService extends BaseService implements Repository<Prescription >{

    public PrescriptionService(){
        super();
    }

    public boolean create(Prescription prescription) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(prescription);
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

//    public boolean update(Prescription prescription) {
//        try {
//            session = sessionFactory.openSession();
//            session.beginTransaction();
//            session.update(prescription);
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

//    public boolean delete(Prescription o) {
//        try {
//            session = sessionFactory.openSession();
//            session.beginTransaction();
//            session.delete(prescription);
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

    public Prescription findById(long id) {
        try {
            Prescription prescription = null;
            session = sessionFactory.openSession();
            prescription = (Prescription) session.get(Prescription .class, id);
            return prescription;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<Prescription > findAll() {
        try {
            List<Prescription > prescriptionList = null;
            session = sessionFactory.openSession();
            Query<Prescription > prescriptionQuery = session.createQuery("from Prescription ");
            prescriptionList = prescriptionQuery.list();
            return prescriptionList;
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