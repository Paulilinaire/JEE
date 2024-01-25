package com.example.exohospital.services;

import com.example.exohospital.entities.Patient;
import com.example.exohospital.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

public class PatientService extends BaseService implements Repository<Patient> {

    public PatientService(){
        super();
    }

    public boolean create(Patient patient) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(patient);
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

//    public boolean update(Patient patient) {
//        try {
//            session = sessionFactory.openSession();
//            session.beginTransaction();
//            session.update(patient);
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

//    public boolean delete(Patient o) {
//        try {
//            session = sessionFactory.openSession();
//            session.beginTransaction();
//            session.delete(patient);
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

    public Patient findById(long id) {
        try {
            Patient patient = null;
            session = sessionFactory.openSession();
            patient = (Patient) session.get(Patient.class, id);
            return patient;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<Patient> findAll() {
        try {
            List<Patient> patientList = null;
            session = sessionFactory.openSession();
            Query<Patient> patientQuery = session.createQuery("from Patient");
            patientList = patientQuery.list();
            return patientList;
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