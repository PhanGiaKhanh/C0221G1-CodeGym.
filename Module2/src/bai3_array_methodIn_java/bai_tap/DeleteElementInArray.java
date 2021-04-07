package bai3_array_methodIn_java.bai_tap;

import java.util.Scanner;

public class DeleteElementInArray {
    public static void main(String[] args) {
        int[] arr = {10, 4, 6, 7, 8, 6, 0, 0};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Array : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
        System.out.print("Enter index delete : ");
        int indexDel = Integer.parseInt(scanner.nextLine());

//        for (int i = indexDel-1; i < arr.length ; i++) {
//            for (int j = indexDel; j < arr.length; j++) {
//                if (j == i + 1) {
//                    arr[i] = arr[j];
//                }
//            }
//        }
        for (int i = indexDel; i < arr.length-1; i++) {
            arr[i] = arr[i+1];
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
}
