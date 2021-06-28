package com.example.b01_complete_cart.model.service;

import com.example.b01_complete_cart.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IProductService extends IGenericService<Product> {
    Page<Product> searchNameAndPrice(@Param("keySearch") String keySearch, Pageable pageable);
}
