package L7_AbstractClass_Interface.ThucHanh.ListGeometric;

import L6_Inheritance.ThucHanh.Shape.Shape;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;

public class ShapeComparatorTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        shapes[0] = new Shape();
        shapes[1] = new Shape("Red",true);
        shapes[2] = new Shape("Blue",false);
        shapes[3] = new Shape("Green",true);

        for (Shape S : shapes){
            System.out.println(S);
        }

        Comparator shapeComparator = new ShapeComparator();
        Arrays.sort(shapes, shapeComparator);
        System.out.println();
        for (Shape S : shapes) {
            System.out.println(S);
        }
        System.out.println(shapes[0].getColor().compareTo(shapes[3].getColor()));

        System.out.println(shapes[0].getColor().compareToIgnoreCase(shapes[3].getColor()));
    }
}
