package bai11_dsa_stack_queue.bai_tap.reverse_array_stack;

import bai11_dsa_stack_queue.thuc_hanh.implement_stack.MyGenericStack;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        MyGenericStack<Integer> stack = new MyGenericStack();
        int[] array = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(array));
        for (int element : array){
            stack.push(element);
        }
        int index = 0;
        while (!stack.isEmpty()){
            array[index] = stack.pop();
            index++;
        }
        System.out.println(Arrays.toString(array));
    }
}
