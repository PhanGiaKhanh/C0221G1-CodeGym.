package L7_AbstractClass_Interface.ThucHanh.ListGeometric;

import L6_Inheritance.ThucHanh.Shape.Rectangle;

import java.util.Arrays;
import java.util.Comparator;

public class RectangleComparatorTest {
    public static void main(String[] args) {
        Rectangle[] rectangles = new Rectangle[4];
        rectangles[0] = new Rectangle(10,20);
        rectangles[1] = new Rectangle();
        rectangles[2] = new Rectangle(1,2,"RED",true);
        rectangles[3] = new Rectangle(20,10,"RED",true);

        for (Rectangle R : rectangles){
            System.out.println("   >>>    "+R);
        }

        Comparator rectangleComparator = new RectangleComparator();
        Arrays.sort(rectangles, rectangleComparator);

        for (Rectangle R : rectangles){
            System.out.println(">>>  " + R);
        }
    }
}
