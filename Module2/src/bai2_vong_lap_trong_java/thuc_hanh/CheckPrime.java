package bai2_vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number : ");
        int num = Integer.parseInt(scanner.nextLine());
        String display = "";
        if (checkPrime(num)) {
            display += " is a prime";
        } else {
            display += " is not a prime";
        }
        System.out.print(num + display);
    }

    static boolean checkPrime(int number) {
        boolean check = true;
        if (number < 2) {
            check = false;
        } else {
            for (int i = 2; i < Math.sqrt(number); i++) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }
}
