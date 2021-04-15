package bai11_thuc_hanh.product_2;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManager2 extends Product {
    static ArrayList<Product> arrayList = new ArrayList();
    static Scanner scanner = new Scanner(System.in);
    static int count = 0;
    public ProductManager2() {
    }

    public ProductManager2(String name, double price) {
        super(name, price);
    }

    public ProductManager2(int id, String name, double price) {
        super(id, name, price);
    }

    public static void addProduct() {
        count = arrayList.size();
        count ++;
        int id =count;
        System.out.print("Input name product: ");
        String name = scanner.nextLine();
        System.out.print("Input price product: ");
        double price = Double.parseDouble(scanner.nextLine());
        arrayList.add(new Product(id, name, price));
    }

    public static void editProduct() {
        System.out.print("Input id you need edit: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Product product : arrayList) {
            if (product.getId() == id) {
                System.out.print("Edit name: ");
                String name = scanner.nextLine();
                System.out.print("Edit price: ");
                double price = Double.parseDouble(scanner.nextLine());
                product.setName(name);
                product.setPrice(price);
            }
        }
        System.out.println("Not exist id");
    }

    public static void deleteProduct() {
        System.out.print("Input id you need delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Product product : arrayList) {
            if (product.getId() == id) {
                System.out.println("You want to delete " + product + " (Y/N)");
                char choose = scanner.nextLine().charAt(0);
                if (choose == 'Y') {
                    arrayList.remove(product);
                    System.out.println("Deleted product: " + product);
                    return;
                } else {
                    return;
                }
            }
        }
        System.out.println("Not exist id");
    }

    public static void displayProduct() {
        System.out.println("List product: ");
        arrayList.forEach(e -> System.out.println(e));
    }

    public static void searchName() {
        System.out.println("Enter name product you need search: ");
        String name = scanner.nextLine();
        for (Product product : arrayList) {
            if (product.getName() == name) {
                System.out.println(name + " product you search: " + product);
                return;
            }
        }
        System.out.println("Not exist " + name + " in products list");
    }

    public static void sortName() {
        arrayList.sort(Comparator.comparing(Product::getName));
        displayProduct();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int choose;
        arrayList.add(new Product(1,"ly",20));
        arrayList.add(new Product(2,"chen",22));
        arrayList.add(new Product(3,"to",25));
        do {
            System.out.println("Choose: \n" +
                    "1. add product \n" +
                    "2. Edit product for id\n" +
                    "3. Delete product for id\n" +
                    "4. Display product list\n" +
                    "5. Search name product \n" +
                    "6. Sort for name product \n" +
                    "0. Exit");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    editProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    displayProduct();
                    break;
                case 5:
                    searchName();
                    break;
                case 6:
                    sortName();
                    break;
            }
        } while (choose != 0);
    }


}
