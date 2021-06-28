package com.example.b03_add_product_to_cart.model.repository;

import com.example.b03_add_product_to_cart.model.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
}
