package model.repository;

import model.bean.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone12", 200, "New", "Iphone"));
        products.put(2, new Product(2, "Iphone12 Pro", 300, "New", "Iphone"));
        products.put(3, new Product(3, "Iphone12 Max", 410, "New", "Iphone"));
        products.put(4, new Product(4, "Samsung Note 20", 320, "New", "Samsung"));
        products.put(5, new Product(5, "Samsung Galaxy Z", 500, "New", "Samsung"));
    }
    public  int getSize(){
        return products.size();
    }

    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }


    public void save(Product product) {
        products.put(product.getId(), product);
    }


    public Product findById(int id) {
        return products.get(id);
    }


    public void update(int id, Product product) {
        products.put(id, product);
    }


    public void remove(int id) {
        products.remove(id);
    }

}
