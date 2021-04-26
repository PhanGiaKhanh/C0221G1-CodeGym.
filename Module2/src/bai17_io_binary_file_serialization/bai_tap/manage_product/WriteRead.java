package bai17_io_binary_file_serialization.bai_tap.manage_product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteRead {
    public static void writeFile(String path, List<Product> products) throws Exception{
        try{
            FileOutputStream fo = new FileOutputStream(path,true);
            ObjectOutputStream oos = new ObjectOutputStream(fo);
            oos.writeObject(products);
            oos.close();
            fo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Product> readFile(String path){
        List<Product> list = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static  void search() {

    }
    public static void main(String[] args) throws Exception {
        ArrayList<Product> listProduct = new ArrayList<>();
        Product ly = new Product("01","Ly","Song Long", 12000,"Gia dụng");
        Product chen = new Product("02","Chen","Song Long", 10000,"Gia dụng");
        Product to = new Product("03","To","Song Long", 15000,"Gia dụng");
        Product bat = new Product("04","Bat","Song Long", 12000,"Gia dụng");
        Product hello = new Product("05","Bat","Song Long", 12000,"Gia dụng");
        listProduct.add(ly);
        listProduct.add(chen);
        listProduct.add(to);
        listProduct.add(bat);
        listProduct.add(hello);
        String path = "src/bai17_io_binary_file_serialization/bai_tap/manage_product/list.txt";
        writeFile(path, listProduct);

        List<Product> listData = readFile(path);
        for (Product product : listData) {
            System.out.println(product);
        }
    }
}
