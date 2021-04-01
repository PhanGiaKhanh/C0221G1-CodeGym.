package L3_Array_MethodInJava.BaiTap;

import java.util.Scanner;

public class CountChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input string : ");
        String str = scanner.nextLine();
        System.out.print("Input char  : ");
        char x = scanner.nextLine().charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (x == str.charAt(i)) {
                count++;
            }
        }
        System.out.print("String input : " + str);
        System.out.println();
        System.out.print("Số char "+ x +" : " + count);
    }
}
