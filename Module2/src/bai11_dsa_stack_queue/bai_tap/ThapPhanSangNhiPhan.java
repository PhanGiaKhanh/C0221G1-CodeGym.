package bai11_dsa_stack_queue.bai_tap.thap_phan_sang_nhin_phan;

import java.util.*;

public class ThapPhanSangNhiPhan {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 1 number integer: ");
        int number = Integer.parseInt(scanner.nextLine());

        exchangeBinary(stack, number);
    }

    private static void exchangeBinary(Stack<Integer> stack, int number) {
        int temp = number;
        while (temp > 0) {
            stack.push(temp % 2);
            temp = temp/2;
        }
        System.out.printf("Enter number: %d \nExchange binary is: ", number);
        while (!stack.isEmpty()){
            System.out.printf(" %d", stack.pop());
        }
    }

    private static boolean isDivisible(int number) {
        return number % 2 != 0;
    }
}
