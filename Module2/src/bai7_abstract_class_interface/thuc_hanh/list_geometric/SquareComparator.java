package bai7_abstract_class_interface.thuc_hanh.list_geometric;

import bai6_inheritance.thuc_hanh.shape.Square;

import java.util.Comparator;

public class SquareComparator implements Comparator<Square> {
    @Override
    public int compare(Square o1, Square o2) {
        if (o1.getPerimeter() > o2.getPerimeter()) return 1;
        else if (o1.getPerimeter() < o2.getPerimeter()) return -1;
        else return 0;
    }
}
