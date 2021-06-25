package com.example.b03_product_springboot.model.service;

import com.example.b03_product_springboot.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IGenericService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Integer id);

    void save(T t);

    void remove(Integer id);

}
