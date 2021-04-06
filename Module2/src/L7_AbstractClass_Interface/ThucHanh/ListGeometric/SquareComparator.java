package L7_AbstractClass_Interface.ThucHanh.ListGeometric;

import L6_Inheritance.ThucHanh.Shape.Square;

import java.util.Comparator;

public class SquareComparator implements Comparator<Square> {
    @Override
    public int compare(Square o1, Square o2) {
        if (o1.getPerimeter() > o2.getPerimeter()) return 1;
        else if (o1.getPerimeter() < o2.getPerimeter()) return -1;
        else return 0;
    }
}
