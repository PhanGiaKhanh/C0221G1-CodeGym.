package bai11_dsa_stack_queue.bai_tap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        String string = "Able was I ere I saw Elba";
        String[] temp = string.toLowerCase().split("");
        Queue<String> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();

        stringPalindrome(temp, queue, stack);
        System.out.println();
        isPalindrome(string,temp, stack);
    }

    private static void stringPalindrome(String[] temp, Queue<String> queue, Stack<String> stack) {
        for(String s: temp){
            stack.push(s.toLowerCase());
            queue.add(s.toLowerCase());
        }
        while (!stack.isEmpty()) {
            boolean check = stack.pop().equals(queue.poll());
            if (!check) {
                System.out.println("No is a string Palindrome");
                System.exit(0);
            }
        }
        System.out.println("Is a string Palindrome");
    }

    private static void isPalindrome(String string, String[] temp, Stack<String> stack) {
        for (int i = 0; i < temp.length; i++) {
            stack.push(temp[i]);
        }
        String reverse = "";
        while (!stack.isEmpty()) {
            reverse += stack.pop();
        }
        if (reverse.equals(string.toLowerCase())) {
            System.out.println("\"" + string + "\"" + "\nString enter is Palindrome");
        } else {
            System.out.println(string + "\nString enter is NOT Palindrome");
        }
    }
}
