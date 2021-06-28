package com.example.b03_add_product_to_cart.model.service;


import com.example.b03_add_product_to_cart.model.entity.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
