package bai7_abstract_class_interface.thuc_hanh.list_geometric;

import bai6_inheritance.thuc_hanh.shape.Shape;

import java.util.Comparator;

public class ShapeComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape a, Shape b) {
       return a.getColor().compareToIgnoreCase(b.getColor());
    }
}
