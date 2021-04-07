package bai3_array_methodIn_java.bai_tap;

import java.util.Scanner;

public class CombineArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size Array 1 : ");
        int N1 = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter size Array 2 : ");
        int N2 = Integer.parseInt(scanner.nextLine());
        int[] array1 = new int[N1];
        int[] array2 = new int[N2];
        for (int i = 0; i < N1; i++) {
            System.out.print("Enter element "+(i+1)+" Array 2 : ");
            array1[i] = Integer.parseInt(scanner.nextLine());
        }
        for (int i = 0; i < N2; i++) {
            System.out.print("Enter element "+(i+1)+" Array 2 : ");
            array2[i] = Integer.parseInt(scanner.nextLine());
        }
        int[] array3= new int[N1+N2];
        for (int i = 0; i < array3.length; i++) {
            if (i<N1) {
                array3[i] = array1[i];
            }
            if (i >= N1) {
                array3[i] = array2[i-N1];
            }
        }
        System.out.print("Array : ");
        for (int i = 0; i < array3.length; i++) {
            System.out.print(array3[i] + "  ");
        }
    }
}
