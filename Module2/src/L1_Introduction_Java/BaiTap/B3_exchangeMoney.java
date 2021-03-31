package L1_Introduction_Java.BaiTap;

import java.util.Scanner;

public class B3_exchangeMoney {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter money USD ");
        int USD = Integer.parseInt(scanner.nextLine());
        int VND = USD * 23000;
        System.out.println("Số tiền quy đổi là " + VND);
    }
}
