package com.example.b01_count_view_page.model.service;

import java.util.Optional;

public interface IGenericService<T> {
    Iterable<T> findAll();
    Optional<T> findById();
    void save(T t);
    void remove(Integer id);
 }
