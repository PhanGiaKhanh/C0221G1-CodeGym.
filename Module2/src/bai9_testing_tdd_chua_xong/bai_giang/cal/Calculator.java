package bai9_testing_tdd_chua_xong.bai_giang.cal;

public class Calculator {
    public int add(int firstOperand, int secondOperand) {
        if (firstOperand / 2 + secondOperand / 2 >= Integer.MAX_VALUE / 2) {
            throw new RuntimeException("out of range exception");
        }
        if (firstOperand / 2 + secondOperand / 2 <= Integer.MIN_VALUE / 2) {
            throw new RuntimeException("out of range exception");
        }
        return firstOperand + secondOperand;
    }
}
