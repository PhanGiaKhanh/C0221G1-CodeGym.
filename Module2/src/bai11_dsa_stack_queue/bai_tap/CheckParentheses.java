package bai11_dsa_stack_queue.bai_tap;

import java.util.Stack;

public class CheckParentheses {
    public static void main(String[] args) {
//        String[] strings = "s * (s – a) * (s – b) * (s – c)".split("");
//        String[] strings = "(– b + (b2 – 4*a*c)^0.5) / 2*a ".split("");
//        String[] strings = "s * (s – a) * (s – b * (s – c)".split("");
//        String[] strings = "s * (s – a) * s – b) * (s – c)".split("");
        String[] strings = "(– b + (b^2 – 4*a*c)^(0.5/ 2*a)".split("");
        Stack<String> bStack = new Stack<>();
        String sym;
        for (String string : strings) {
//            sym = "(";
            if (string.equals("(")) {
                bStack.push("(");
            }
//            sym = ")";
            if (string.equals(")")) {
                if (bStack.isEmpty()) {
                    System.out.println(false + " 1");
                    return;
                }
                String left = bStack.pop();
                if (left.equals(")")) {
                    System.out.println(false + " 2");
                    return;
                }
            }
        }
        if (bStack.isEmpty()){
            System.out.println(true);
        }else {
            System.out.println(false + " 3");
        }
    }
}
