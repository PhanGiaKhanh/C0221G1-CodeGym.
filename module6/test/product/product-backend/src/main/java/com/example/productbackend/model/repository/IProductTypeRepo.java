package com.example.productbackend.model.repository;

import com.example.productbackend.model.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductTypeRepo extends JpaRepository<ProductType, Long> {
}
