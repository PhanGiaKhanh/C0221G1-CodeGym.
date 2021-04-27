package bai17_io_binary_file_serialization.bai_tap.manage_product;

import bai17_io_binary_file_serialization.thuc_hanh.read_write_list_student.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageProduct {
    List<Product> listProduct = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    String path = "src/bai17_io_binary_file_serialization/bai_tap/manage_product/list.txt";

    public void createProduct() {
        Product ly = new Product("01", "Ly", "Song Long", 12000, "Gia dụng");
        Product chen = new Product("02", "Chen", "Song Long", 10000, "Gia dụng");
        Product to = new Product("03", "To", "Song Long", 15000, "Gia dụng");
        Product bat = new Product("04", "Bat", "Song Long", 12000, "Gia dụng");
        listProduct.add(ly);
        listProduct.add(chen);
        listProduct.add(to);
        listProduct.add(bat);
        try {
            writeFile(path, listProduct);
        } catch (Exception e) {
            System.out.println("Lỗi " + e);
        }

    }

    public void menuProduct()  {
        int choose;
        boolean isExit = false;
        do {
            System.out.println("1. Add product\n" +
                    "2. Delete product\n" +
                    "3. Show list product \n" +
                    "4. Search id \n" +
                    "5. Exit \n" +
                    "Choose:  ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    deleteProduct();
                    break;
                case 3:
                    showListProduct();
                    break;
                case 4:
                    searchId();
                    break;
                case 5:
                    isExit = true;
                    break;
                default:
                    System.err.println("________Please choose 1-5________");
            }
            if (isExit) {
                break;
            }
        } while (true);
    }

    private void searchId() {
    }

    private void showListProduct() {
        try {
            List<Product> listShow = readFile(path);
            listShow.forEach(e -> System.out.println(e));
        }catch (Exception e){
            System.out.println("Lỗi không tìm thấy file " +e );
        }

    }

    private void deleteProduct() {

    }

    private void addProduct() {
        String productCode;
        String productName;
        String manufacturer;
        double price;
        String otherDescription;
        try {
            System.out.println("Add new product :");
            System.out.print("Please input product code: ");
            productCode = scanner.nextLine();
            System.out.print("Please input product name: ");
            productName = scanner.nextLine();
            System.out.print("Please input manafacturer: ");
            manufacturer = scanner.nextLine();
            System.out.print("Please input price");
            price = Double.parseDouble(scanner.nextLine());
            System.out.print("Please input other description: ");
            otherDescription = scanner.nextLine();
            listProduct.add(new Product(productCode, productName, manufacturer, price, otherDescription));
            writeFile(path, listProduct);
        }catch (Exception e) {
            System.err.println("Lỗi " + e);
        }

    }

    public void writeFile(String path, List<Product> products) {
        try {
            FileOutputStream fo = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fo);
            oos.writeObject(products);
            oos.close();
            fo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Product> readFile(String path) {
        List<Product> list = new ArrayList<>();
        try {
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
}
