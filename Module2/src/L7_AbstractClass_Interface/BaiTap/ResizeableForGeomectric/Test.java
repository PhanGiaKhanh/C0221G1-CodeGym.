package L7_AbstractClass_Interface.BaiTap.ResizeableForGeomectric;

public class Test {
    public static void main(String[] args) {
        // Circle
        Circle circle = new Circle();
        circle.resize(2);
        System.out.println(circle);

        //Rectangle
        Rectangle rectangle = new Rectangle();
        rectangle.resize(2);
        System.out.println(rectangle);

        //Square
        Square square = new Square();
        square.resize(2);
        System.out.println(square);
    }
}
