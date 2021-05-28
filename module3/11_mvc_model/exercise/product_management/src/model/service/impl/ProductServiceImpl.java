package model.service.impl;

import model.bean.Product;
import model.repository.ProductRepository;
import model.service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {

    ProductRepository products = new ProductRepository();

    @Override
    public List<Product> findAll() {
        return products.findAll();
    }

    @Override
    public void save(Product product) {
        products.save(product);
    }

    @Override
    public Product findById(int id) {
        return products.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        products.update(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public int getSize() {
        return products.getSize();
    }

}
