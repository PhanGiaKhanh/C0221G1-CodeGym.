package com.example.productbackend.model.service.imple;

import com.example.productbackend.model.entity.ProductType;
import com.example.productbackend.model.repository.IProductTypeRepo;
import com.example.productbackend.model.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeService implements IProductTypeService {
    @Autowired
    IProductTypeRepo iProductTypeRepo;
    @Override
    public Iterable<ProductType> findAll() {
        return iProductTypeRepo.findAll();
    }
}
