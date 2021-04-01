package L3_Array_MethodInJava.BaiTap;

import java.util.Scanner;

public class SearchMinInArray {
    public static void main(String[] args) {
        int[] array = inputArray();
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]){
                min = array[i];
            }
        }
        System.out.println("Min in array is : " + min);
    }
    public static int[] inputArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size Array : ");
        int size = Integer.parseInt(scanner.nextLine());
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element "+(i+1)+" Array  : ");
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        return array;
    }
}
