package com.example.productbackend.model.service;

import com.example.productbackend.model.entity.ProductType;

public interface IProductTypeService {
    Iterable<ProductType> findAll();
}
