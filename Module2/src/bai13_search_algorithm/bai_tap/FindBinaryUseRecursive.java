package bai13_search_algorithm.bai_tap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FindBinaryUseRecursive {
    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};

    static boolean binarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        if (high>=low) {
            int mid = (low + high) / 2;
            if (key < list[mid]) {
                int[] temp = new int[mid];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = list[i];
                }
                list = temp;
                temp = null;
                high=mid -1;
                return binarySearch(list, key);

            } else if (key > list[mid]) {
                low = mid +1;
                int[] temp = new int[high-low+1];
                for (int i = mid+1; i < list.length; i++) {
                    temp[i - mid-1] = list[i];
                }
                list = temp;
                temp = null;
                return binarySearch(list, key);
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(list, 2));  /* 0 */
        System.out.println(binarySearch(list, 11)); /* 4 */
        System.out.println(binarySearch(list, 5));  /*-1 */
        System.out.println(binarySearch(list, 79)); /*12 */
        System.out.println(binarySearch(list, 1));  /*-1 */
        System.out.println(binarySearch(list, 80)); /*-1 */
    }
}
