package L3_Array_MethodInJava.ThucHanh;

import java.util.Scanner;

public class SearchMaxInArray {
    public static void main(String[] args) {
        byte size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size : ");
            size = Byte.parseByte(scanner.nextLine());
            if (size > 20 && size < 0){
                System.out.println("Size should not exceed 20");
            }
        } while (size > 20 && size < 0);
        array = new int[size];
        byte index = 0;
        while (index < size) {
            System.out.print("Enter element " + (index+1) + " : ");
            array[index] = Integer.parseInt(scanner.nextLine());
            index++;
        }
        System.out.print("Property list : ");
        for (byte i = 0; i < size; i++) {
            System.out.print(array[i] + "  ");
        }
        int max = array[0];
        for (byte i = 0; i < size; i++) {
            if (max < array[i]){
                max = array[i];
                index = i;
            }
        }
        System.out.println("The largest property value in the list is " + max + ", at position " + index);
    }
}
