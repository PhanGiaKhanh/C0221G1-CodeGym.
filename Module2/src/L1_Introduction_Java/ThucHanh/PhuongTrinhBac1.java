package L1_Introduction_Java.ThucHanh;

import java.sql.SQLOutput;
import java.util.Scanner;

public class PhuongTrinhBac1 {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = c', please enter constants:");

        Scanner scanner = new Scanner(System.in);

        System.out.println("a  : ");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.println("b  : ");
        double b = Double.parseDouble(scanner.nextLine());
        System.out.println("c  : ");
        double c = Double.parseDouble(scanner.nextLine());

        if(a!=0) {
            double solution = (c-b)/a;
            System.out.printf("Equation pass with x = %f!\n" , solution);
        }else {
            if (b == 0) {
                System.out.print("The solution is all x!");
            } else {
                System.out.print("No solution!");
            }
        }
    }
}
