package L1_Introduction_Java.ThucHanh;

import java.util.Scanner;

public class CaculatorBodyWeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double height, weight, bmi;

        System.out.println("Enter your height : ");
        height = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter your weight : ");
        weight = Double.parseDouble(scanner.nextLine());

        bmi = weight / Math.pow(height, 2);
        System.out.printf("%-4s%s", "bmi", "Interpretation\n");
        if (bmi < 18)
            System.out.printf("%-20.2f%s", bmi, "Underweight");
        else if (bmi < 25.0)
            System.out.printf("%-20.2f%s", bmi, "Normal");
        else if (bmi < 30.0)
            System.out.printf("%-20.2f%s", bmi, "Overweight");
        else
            System.out.printf("%-20.2f%s", bmi, "Obese");
    }
}
