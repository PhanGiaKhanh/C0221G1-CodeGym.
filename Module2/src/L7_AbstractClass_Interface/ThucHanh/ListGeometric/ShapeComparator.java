package L7_AbstractClass_Interface.ThucHanh.ListGeometric;

import L6_Inheritance.ThucHanh.Shape.Shape;

import java.io.File;
import java.util.Comparator;

public class ShapeComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape a, Shape b) {
       return a.getColor().compareToIgnoreCase(b.getColor());
    }
}
