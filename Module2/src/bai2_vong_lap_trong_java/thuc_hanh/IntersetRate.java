package bai2_vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class IntersetRate {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter money : ");
        double money = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter month : ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter interest rate : ");
        double interest_rate = Double.parseDouble(scanner.nextLine());

        double total_interest = 0;
        for (byte i = 0; i < month; i++) {
            total_interest += money * (interest_rate/100)/12 * month;
        }

        System.out.print("Total of interest : " + total_interest );
    }
}
