package bai11_dsa_stack_queue;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<Product>();
        list.add(new Product(1, "Samsung A8", 17000f));
        list.add(new Product(3, "Iphone 8X", 65000f));
        list.add(new Product(2, "Iphone 8X", 25000f));
        list.add(new Product(4, "Nokia L7", 15000f));
        list.add(new Product(5, "Redmi Note 7", 26000f));
        list.add(new Product(6, "Lenevo Vibe", 19000f));

//        list.sort(Comparator.comparing(Product::getName).thenComparing(Product::getPrice));
//
//        list.forEach(element-> System.out.println(element.name +"  " + element.getPrice()));
        Set<String> set = new HashSet<>();
        set.add("London");
        set.add("Paris");
        set.add("New	York");
        set.add("San	Francisco");
        set.add("Beijing");
        set.add("New	York");
        System.out.println(set);
        for (String s : set) {
            System.out.print(s.toUpperCase() + "	");
        }

    }

}

class Product {
    int id;
    String name;
    float price;

    public Product(int id, String name, float price) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
