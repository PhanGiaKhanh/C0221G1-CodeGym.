package L3_Array_MethodInJava.BaiTap;

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
