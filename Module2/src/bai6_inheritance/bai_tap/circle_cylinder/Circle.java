package bai6_inheritance.bai_tap.circle_cylinder;

public class Circle {
    private double radius = 1.0;
    private String color = "Yellow";

    public Circle() {
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.floor(radius * radius * Math.PI * 100) / 100;
    }

    public double getPerimeter() {
        return Math.floor(radius * 2 * Math.PI * 100) / 100;
    }

    @Override
    public String toString() {
        return "A Circle with Radius = "
                + radius
                + ", color = "
                + color
                + "\n Area = "
                + getArea();
    }
}
