package bai6_inheritance.bai_tap.triangle1;

import bai6_inheritance.thuc_hanh.shape.Shape;
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
