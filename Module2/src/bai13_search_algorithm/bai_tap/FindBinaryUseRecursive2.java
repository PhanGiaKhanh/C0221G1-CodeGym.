package bai13_search_algorithm.bai_tap;

public class FindBinaryUseRecursive2 {
    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};

    static boolean binarySearch(int[] list, int low, int high, int key) {
        if (high >= low) {
            int mid = (high + low) / 2;
            if (key == list[mid]) {
                return true;
            } else if (key < list[mid]) {
                return binarySearch(list, low, mid - 1, key);
            } else {
                return binarySearch(list, mid + 1, high, key);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int low = 0;
        int high = list.length - 1;
        System.out.println(binarySearch(list, low, high, 2));  /* 0 */
        System.out.println(binarySearch(list, low, high, 11)); /* 4 */
        System.out.println(binarySearch(list, low, high, 5));  /*-1 */
        System.out.println(binarySearch(list, low, high, 79)); /*12 */
        System.out.println(binarySearch(list, low, high, 1));  /*-1 */
        System.out.println(binarySearch(list, low, high, 80)); /*-1 */
    }
}
