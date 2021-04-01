package L3_Array_MethodInJava.BaiTap;

import java.util.Scanner;

public class SearchMaxMutiArray {
    public static void main(String[] args) {
        int[][] array = inputMutiArray();
        displayMutiArray(array);
        System.out.print("Giá trị lớn nhất là : " + searchMaxArray2(array) );

    }

    public static int searchMaxArray2 (int[][] array2) {
        int max = array2[0][0];
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                if (max < array2[i][j]){
                    max= array2[i][j];
                }
            }
        }
        return max;
    }
    public static void displayMutiArray(int[][] array2) {
        for (int i = 0; i < array2.length; i++) {
            System.out.println();
            for (int j = 0; j < array2[i].length; j++) {
                System.out.print(array2[i][j] + "  ");
            }
        }
    }

    public static int[][] inputMutiArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter row  : ");
        int row = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter column : ");
        int col = Integer.parseInt(scanner.nextLine());
        int[][] array = new int[row][col];
        for (int i = 0; i < row; i++) {
            System.out.println("Row " + i + " : ");
            for (int j = 0; j < col; j++) {
                System.out.print("Enter element " + (j + 1) + " : ");
                array[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        return array;
    }
}
