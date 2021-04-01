package L3_Array_MethodInJava.BaiTap;

import java.util.Scanner;

public class TotalAColumn {
    public static void main(String[] args) {
        int[][] array = SearchMaxMutiArray.inputMutiArray();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter column : ");
        int col = Integer.parseInt(scanner.nextLine());
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j == col-1){
                    total += array[i][j];
                }
            }
        }
        SearchMaxMutiArray.displayMutiArray(array);
        System.out.println();
        System.out.println("Total column "+ col + " là : " + total);
    }
}
