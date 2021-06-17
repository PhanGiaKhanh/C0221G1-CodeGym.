package com.service;

import java.util.List;

public interface GeneralService<T> {
    List<T> findAll();

    T findOne(Long id);

    T save(T t);

    List<T> save(List<T> t);

    boolean exists(Long id);

    List<T> findAll(List<Long> ids);

    long count();

    void delete(Long id);

    void delete(T t);

    void delete(List<T> t);

    void deleteAll();
}
