package model.repository;

import com.sun.javafx.collections.MappingChange;
import model.bean.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {
    static Map<Integer, Product> map = new HashMap<>();

    static {
        map.put(1, new Product(1, "Iphone 10", 12000, "New", "Iphone"));
        map.put(2, new Product(2, "Iphone 11", 15000, "New", "Iphone"));
        map.put(3, new Product(3, "Iphone 12", 18000, "New", "Iphone"));
        map.put(4, new Product(4, "SamSung 10", 12500, "New", "SamSung"));
        map.put(5, new Product(5, "SamSung 11", 14000, "New", "SamSung"));
        map.put(6, new Product(6, "SamSung 12", 19000, "New", "SamSung"));
    }

    public int size(){
        return map.size();
    }
    public List<Product> findAll(){
        return new ArrayList<>(map.values());
    }

    public Product findId(int id){
        return  map.get(id);
    }

    public void save(Product product){
        map.put(size()+1, product);
    }

    public void update(Product product){
        map.put(product.getId(), product);
    }

    public void remove(int id){
        map.remove(id);
    }
}
