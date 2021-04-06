package L7_AbstractClass_Interface.ThucHanh.ListGeometric;
import L6_Inheritance.ThucHanh.Shape.Rectangle;
import java.util.Comparator;
public class RectangleComparator implements Comparator<Rectangle> {
    @Override
    public int compare(Rectangle r1, Rectangle r2){
        if (r1.getPerimeter()>r2.getPerimeter()) return 1;
        else if (r1.getPerimeter()<r2.getPerimeter()) return -1;
        else return 0;
    }
//
//    @Override
//    public int compare(Rectangle o1, Rectangle o2) {
//        return 0;
//    }
}
