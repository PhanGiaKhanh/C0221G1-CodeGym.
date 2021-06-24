package com.example.b03_product_springboot.model.service;


import com.example.b03_product_springboot.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductService extends IGenericService<Product> {
    Page<Product> searchNameAndDate(@Param("search") String search, Pageable pageable);
//
    Page<Product> findAllSortDate(Pageable pageable);
}