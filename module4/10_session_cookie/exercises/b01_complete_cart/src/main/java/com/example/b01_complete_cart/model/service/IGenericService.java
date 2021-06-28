package com.example.b01_complete_cart.model.service;

import java.util.Optional;

public interface IGenericService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Integer id);
    void save(T t);
    void remove(Integer id);
 }
