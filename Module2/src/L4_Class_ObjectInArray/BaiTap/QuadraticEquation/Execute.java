package L4_Class_ObjectInArray.BaiTap.QuadraticEquation;

import java.util.Scanner;

class Execute {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quadratic Equation ax2 + bx + c = 0");
        System.out.print("Enter a : ");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter b : ");
        double b = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter c : ");
        double c = Double.parseDouble(scanner.nextLine());

        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);

        System.out.println("Quadratic Equation : " + quadraticEquation.getA() + "x2 + " + quadraticEquation.getB() + "x + " + quadraticEquation.getC());
        System.out.println("Delta : " + quadraticEquation.getDelta());
        System.out.println(quadraticEquation.getResult());
    }
}
