package bai6_inheritance.bai_tap.point_moveable_point;

public class Test {
    public static void main (String[] args){
//        Point point =new Point();
//        System.out.println(point);
//
//        point = new Point(1,2);
//        System.out.println(point);

        MovablePoint movablePoint = new MovablePoint();
        System.out.println(movablePoint);

        movablePoint = new MovablePoint(10,10);
        System.out.println(movablePoint);

        movablePoint = new MovablePoint( 1,2,3,4);
        System.out.println(movablePoint);
    }
}
