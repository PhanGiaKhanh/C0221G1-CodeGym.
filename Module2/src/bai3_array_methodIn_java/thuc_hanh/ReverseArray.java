package bai3_array_methodIn_java.thuc_hanh;

import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte size;
        int[] array;
        do {
            System.out.print("Enter a size : ");
            size = Byte.parseByte(input.nextLine());
            if (size > 20) {
                System.out.println("Size does not exceed 20");
            }
        } while (size > 20);
        array = new int[size];
        byte index = 0;
        while (index < array.length) {
            System.out.print("Enter element " + (index + 1) + " : ");
            array[index] = Integer.parseInt(input.nextLine());
            index++;
        }

        System.out.print("Elements in array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }

        int temp;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        System.out.print("Reverse array: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "  ");
        }
    }


}
