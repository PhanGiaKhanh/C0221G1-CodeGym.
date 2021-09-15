package com.example.productbackend.model.service;

import com.example.productbackend.model.entity.Product;
import com.example.productbackend.model.entity.ProductType;

public interface IProductService extends IGeneralService<Product>{
    Iterable<ProductType> findProductTypes();

}
