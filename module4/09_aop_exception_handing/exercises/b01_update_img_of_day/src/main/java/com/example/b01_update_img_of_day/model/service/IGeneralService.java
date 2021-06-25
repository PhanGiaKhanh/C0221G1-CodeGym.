package com.example.b01_update_img_of_day.model.service;

import java.util.Optional;


public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id) throws Exception;

    void save(T t);

    void remove(Long id);


}
