package L1_Introduction_Java.ThucHanh;

import java.util.Scanner;

public class Operator {
    public static void main(String[] args) {
        float width = 0;
        float height;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter width: ");
        width = Float.parseFloat(scanner.nextLine());

        System.out.println("Enter height: ");
        height = Float.parseFloat(scanner.nextLine());
        float area = width * height;
        System.out.println("Area is: " + area);
    }
}
