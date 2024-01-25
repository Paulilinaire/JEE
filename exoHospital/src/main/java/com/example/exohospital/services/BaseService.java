package com.example.exohospital.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public abstract class BaseService {

    protected StandardServiceRegistry registry;

    protected SessionFactory sessionFactory;

    protected Session session;

    public BaseService() {
        registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

    }
}
