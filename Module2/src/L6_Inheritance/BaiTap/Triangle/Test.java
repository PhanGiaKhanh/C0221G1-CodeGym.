package L6_Inheritance.BaiTap.Triangle;

import L6_Inheritance.ThucHanh.Shape.Shape;
public class Test {
    public static void main (String[] args ){
        Shape shape = new Shape();
        System.out.println(shape);

        Triangle triangle = new Triangle();
        System.out.println(triangle);

        triangle = new Triangle(3,2,3);
        System.out.println(triangle);

        triangle = new Triangle("Red", false, 3,2,3);
        System.out.println(triangle);
    }
}
