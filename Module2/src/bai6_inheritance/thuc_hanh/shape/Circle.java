package bai6_inheritance.thuc_hanh.shape;

public class Circle<F> extends Shape {
    private double radius = 1.0;
    final double PI = (Math.floor(Math.PI * 100) / 100);

    public Circle() {
    }
    public Circle(double radius){
        this.radius = radius;
    }
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * PI;
    }

    public double getPerimeter() {
        return 2 * radius * PI;
    }

    public String toString() {
        return "A Circle with radius = "
                + getRadius()
                + ", which is a subclass of "
                + super.toString();
    }
}
