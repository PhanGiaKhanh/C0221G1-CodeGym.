package bai14_sort_algorithm.bai_tap;

public class SetInsertionSort {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};
    public static void insertionSort(double[] list) {
        for (int i = 1; i < list.length ; i++) {
            double currentElement = list[i];
            int j = i;

            for (j = i - 1; j >= 0 && list[j]>currentElement ; j--) {
                    list[j+1] = list[j];
                }

            list[j+1] = currentElement;
            }
        }
    public static void main(String[] args) {
        insertionSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
}
