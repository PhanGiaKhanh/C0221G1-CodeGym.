package com.example.productbackend.model.service.imple;

import com.example.productbackend.model.entity.Product;
import com.example.productbackend.model.entity.ProductType;
import com.example.productbackend.model.repository.IProductRepo;
import com.example.productbackend.model.repository.IProductTypeRepo;
import com.example.productbackend.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepo iProductRepo;
    @Autowired
    IProductTypeRepo iProductTypeRepo;
    @Override
    public Iterable<Product> findAll() {
        return iProductRepo.findAll();
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepo.findAll(pageable);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return iProductRepo.findById(id);
    }

    @Override
    public Product save(Product product) {
        return iProductRepo.save(product);
    }

    @Override
    public void deleteById(Long idDelete) {
        iProductRepo.deleteById(idDelete);
    }

    @Override
    public Iterable<ProductType> findProductTypes() {
        return iProductTypeRepo.findAll();
    }
}
