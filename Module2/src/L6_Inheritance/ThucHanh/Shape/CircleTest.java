package L6_Inheritance.ThucHanh.Shape;

import org.w3c.dom.ls.LSOutput;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());

        circle = new Circle(10.0);
        System.out.println(circle);
        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());

        circle = new Circle(0.1,"yellow",false);
        System.out.println(circle);
        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());
    }
}
