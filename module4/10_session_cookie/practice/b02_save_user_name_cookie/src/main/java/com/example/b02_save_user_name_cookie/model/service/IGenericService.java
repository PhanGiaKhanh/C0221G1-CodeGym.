package com.example.b02_save_user_name_cookie.model.service;

import java.util.Optional;

public interface IGenericService<T> {
    Iterable<T> findAll();
    Optional<T> findById();
    void save(T t);
    void remove(Integer id);
 }
