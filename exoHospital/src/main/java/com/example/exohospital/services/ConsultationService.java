package com.example.exohospital.services;

import com.example.exohospital.entities.Consultation;
import com.example.exohospital.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

public class ConsultationService extends BaseService implements Repository<Consultation> {

    public ConsultationService(){
        super();
    }

    public boolean create(Consultation consultation) {
        long patientId = 0;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.get(Consultation.class, patientId);
            session.saveOrUpdate(consultation);
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

//    public boolean update(Consultation consultation) {
//        try {
//            session = sessionFactory.openSession();
//            session.beginTransaction();
//            session.update(consultation);
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

//    public boolean delete(Consultation o) {
//        try {
//            session = sessionFactory.openSession();
//            session.beginTransaction();
//            session.delete(consultation);
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

    public Consultation findById(long id) {
        try {
            Consultation consultation = null;
            session = sessionFactory.openSession();
            consultation = (Consultation) session.get(Consultation.class, id);
            return consultation;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<Consultation> findAll() {
        try {
            List<Consultation> consultationList = null;
            session = sessionFactory.openSession();
            Query<Consultation> consultationQuery = session.createQuery("from Consultation");
            consultationList = consultationQuery.list();
            return consultationList;
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