package bai11_dsa_stack_queue.bai_tap.reverse_array_stack;

import bai11_dsa_stack_queue.thuc_hanh.implement_stack.MyGenericStack;

import java.sql.Array;
import java.util.Arrays;

public class ReverseArrayString {
    public static void main(String[] args) {
        MyGenericStack<String> wStack = new MyGenericStack<>();
        String string  = "Khanh Phan";
        System.out.println(string);
        String[] arrayString = string.split("");

        for (String character : arrayString) {
            wStack.push(character);
        }

        for (int i = 0; i < arrayString.length; i++) {
            arrayString[i] = wStack.pop();
        }

        string = String.join("",arrayString);
        System.out.println(string);
    }
}
