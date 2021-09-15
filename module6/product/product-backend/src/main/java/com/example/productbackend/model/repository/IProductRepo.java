package com.example.productbackend.model.repository;

import com.example.productbackend.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepo extends JpaRepository<Product, Long> {
}
