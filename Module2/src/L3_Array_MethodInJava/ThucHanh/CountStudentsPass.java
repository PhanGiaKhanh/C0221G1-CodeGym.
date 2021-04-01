package L3_Array_MethodInJava.ThucHanh;

import java.util.Scanner;

public class CountStudentsPass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        int[] array;
        do {
             System.out.print("Enter a size : ");
             size = Integer.parseInt(scanner.nextLine());
             if (size >30) {
                 System.out.println("Size should not exceed 30");
             }
        }while (size > 30);
    }
}
