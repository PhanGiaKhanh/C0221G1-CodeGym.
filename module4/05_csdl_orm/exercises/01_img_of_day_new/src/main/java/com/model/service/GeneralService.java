package com.model.service;

import java.util.List;

public interface GeneralService<T> {
    List<T> findAll();

    T findOne(Long id);

    T save(T t);


    void like(int id);
}
