package com.example.exohospital.interfaces;

import java.util.List;

public interface Repository<T> {

    boolean create(T o);

    T findById(long id);

    List<T> findAll();
}
