package bai3_array_methodIn_java.bai_tap;

public class TotalDiagonal {
    public static void main(String[] args) {
        int[][] array = SearchMaxMutiArray.inputMutiArray();
        SearchMaxMutiArray.displayMutiArray(array);
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j == i) {
                    total += array[i][j];
                }
            }
        }
        System.out.println("Total diagonal : " + total);
    }

}
