package L3_Array_MethodInJava.BaiTap;

import java.util.Scanner;

public class AddElementInArray {
    public static void main(String[] args) {
        int[] arr = {10, 4, 6, 7, 8, 0, 0, 0, 0, 0};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Array : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();

        int index = 0;
        do {
            System.out.print("Enter index add : ");
            index = Integer.parseInt(scanner.nextLine());
            if (index <= 1 || index >= arr.length - 1) {
                System.out.println("No add element in array! Again enter");
            }
        } while (index <= 1 || index >= arr.length - 1);

        System.out.print("Enter element : ");
        int elementAdd = Integer.parseInt(scanner.nextLine());

        int temp;
        for (int i = index-1; i < arr.length-1; i++) {
            temp = arr[i];
            arr[i] = elementAdd;
            elementAdd = temp;
        }
        System.out.print("Array : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

}
