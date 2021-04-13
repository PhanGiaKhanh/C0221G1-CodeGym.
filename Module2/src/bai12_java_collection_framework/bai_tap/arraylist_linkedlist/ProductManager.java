package bai12_java_collection_framework.bai_tap.arraylist_linkedlist;

import java.util.ArrayList;
import java.util.Comparator;

public class ProductManager<E> extends Product {
    static ArrayList<Product> arrayList = new ArrayList<>();

    public static void  add(Product e){
        arrayList.add(e);
    }

    public static void edit(int id, String name, int price){
        for(Product product : arrayList) {
            if (product.getId() == id ){
                product.setName(name);
                product.setPrice(price);
            }
        }
    }
    public static void remove(int id) {
        Product temp = null;
        for(Product product : arrayList) {
            if (product.getId() == id ){
                temp = product;
            }
        }
        arrayList.remove(temp);
    }
    public static void print(){
        arrayList.forEach(e-> System.out.println(e));
    }
    public static void search(String name){
        for (Product e : arrayList)
            if (e.getName().equals(name)){
                System.out.println(name + " in Products");
                return;
            }
        System.out.println(name + " not in Products");
    }
    public static void sortTang(){
        arrayList.sort(Comparator.comparing(Product::getPrice));
    }
    public static void sortGiam(){
        arrayList.sort((Product a, Product b) -> {
            return b.getPrice()-a.getPrice();
        });
    }
    public static void main(String[] args) {
        arrayList.add(new Product(1,"Ly",10000));
        arrayList.add(new Product(2,"Chén",10000));
        arrayList.add(new Product(3,"Đũa",15000));
        arrayList.add(new Product(4,"Tô",20000));
        add(new Product(5,"Bát",20000));
        sortGiam();
        remove(3);
        print();
        System.out.println();
        sortTang();
        print();
        System.out.println();
        edit(1, "Ca", 1200);
        print();
    }
}
