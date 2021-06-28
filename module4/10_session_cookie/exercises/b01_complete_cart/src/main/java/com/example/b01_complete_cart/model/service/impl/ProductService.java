package com.example.b01_complete_cart.model.service.impl;

import com.example.b01_complete_cart.model.entity.Product;
import com.example.b01_complete_cart.model.repository.IProductRepository;
import com.example.b01_complete_cart.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> searchNameAndPrice(String keySearch, Pageable pageable) {
        return productRepository.searchNameAndPrice("%" +keySearch +"%", pageable);
    }
}
