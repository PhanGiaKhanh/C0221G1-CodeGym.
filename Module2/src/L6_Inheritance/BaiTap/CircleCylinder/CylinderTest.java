package L6_Inheritance.BaiTap.CircleCylinder;

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);

        cylinder = new Cylinder(8,6,"Blue");
        System.out.println(cylinder);
    }
}
