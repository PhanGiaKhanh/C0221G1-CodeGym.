package model.service.impl;

import model.bean.Product;
import model.repository.ProductRepository;
import model.service.IProductService;

import java.util.List;

public class ProductImpl implements IProductService {
    ProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findId(id);
    }

    @Override
    public void update( Product product) {
        productRepository.update(product);
    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }

    @Override
    public int size() {
        return productRepository.size();
    }
}
