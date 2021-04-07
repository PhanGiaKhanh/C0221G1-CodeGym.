package bai5_access_modifier.bt_access_modifier;

public class Execute {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        System.out.println(circle);
        Circle circle1 = new Circle(10, "blue");
        System.out.println(circle1);
        System.out.println(circle1);
    }
}
