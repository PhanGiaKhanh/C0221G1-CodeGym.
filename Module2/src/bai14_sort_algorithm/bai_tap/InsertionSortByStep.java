package bai14_sort_algorithm.bai_tap;

import java.util.Scanner;

public class InsertionSortByStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size:");
        int size = scanner.nextInt();
        double[] list = new double[size];
        System.out.println("Enter " + list.length + " values:");
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }
        System.out.print("Your input list: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "   ");
        }
        System.out.println("\nBegin sort processing...");
        bubbleSortByStep(list);
    }

    public static void bubbleSortByStep(double[] list) {
        boolean needNextPass = true;
        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;
            double currentElement = list[k];
            int i;
            for (i = k - 1; i >= 0 && list[i] > currentElement; i--) {
                System.out.println("Swap " + list[i+1] + " with " + list[i]);
                list[i + 1] = list[i];
                needNextPass = true;
            }
            list[i + 1] = currentElement;
//            if (needNextPass == false) {
//                System.out.println("Array may be sorted and next pass not needed");
//                break;
//            }
            System.out.print("List after the  " + k + " sort: ");
            for (int j = 0; j < list.length; j++) {
                System.out.print(list[j] + "  ");
            }
            System.out.println();
        }

    }
}