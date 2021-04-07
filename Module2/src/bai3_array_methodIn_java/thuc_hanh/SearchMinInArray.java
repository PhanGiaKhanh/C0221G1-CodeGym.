package bai3_array_methodIn_java.thuc_hanh;

public class SearchMinInArray {
    public static void main(String[] args){
        int[] array = {4,12,7,8,1,6,9};
        int min = minValue(array);
        System.out.println("The smallest element in the array is: " + min);
    }
    public static int minValue(int[] array){
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]){
                min = array[i];
            }
        }
        return min;
    };
}
