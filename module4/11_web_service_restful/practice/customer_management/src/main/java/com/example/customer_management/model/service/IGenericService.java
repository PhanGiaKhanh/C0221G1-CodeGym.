package com.example.customer_management.model.service;

import java.util.Optional;

public interface IGenericService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    T save(T t);
    void remove(Long id);
}
