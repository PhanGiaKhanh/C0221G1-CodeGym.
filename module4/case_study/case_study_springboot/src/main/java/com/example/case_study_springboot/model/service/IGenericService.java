package com.example.case_study_springboot.model.service;

import java.util.Optional;

public interface IGenericService<T>{
    Iterable<T> findAll();
    Optional<T> findById(Integer id);
    void save(T t);
    void delete(Integer id);
}
