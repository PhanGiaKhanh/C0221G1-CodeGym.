package model.service.impl;

import model.bean.Category;
import model.bean.Product;
import model.repository.ProductRepository;
import model.service.ProductService;

import java.util.List;
import java.util.Map;

public class ProductImpl implements ProductService {
    ProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean insert(Product product) {
        return productRepository.insert(product);
    }

    @Override
    public boolean deleteById(int id) {
        return productRepository.delete(id);
    }

    @Override
    public boolean updateById(Product product) {
        return productRepository.update(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> search(String name) {
        return productRepository.search(name);
    }

    @Override
    public List<Category> findAllCategory() {
        return productRepository.findAllCategory() ;
    }
}
