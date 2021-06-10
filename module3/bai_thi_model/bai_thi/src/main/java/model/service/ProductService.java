package model.service;

import model.bean.Category;
import model.bean.Product;
import model.bean.StudentDemo;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> findAll();
    boolean insert(Product product);
    boolean deleteById(int id);
    boolean updateById(Product product);
    Product findById(int id);
    List<Product> search(String name);
    List<Category> findAllCategory();
}
