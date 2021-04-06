package L7_AbstractClass_Interface.ThucHanh.ListGeometric;

import L6_Inheritance.ThucHanh.Shape.Square;

import java.util.Arrays;
import java.util.Comparator;

public class SquareComparatorTest {
    public static void main(String[] args) {
        Square[] squares = new Square[4];
        squares[0] = new Square();
        squares[1] = new Square(22);
        squares[2] = new Square(2);
        squares[3] = new Square(2,"Red", true);
        byte count = 1;
        for (Square S : squares){
            System.out.println(count +". "+ S);
            count++;
        }

        Comparator squareComparator = new SquareComparator();
        Arrays.sort(squares, squareComparator);

        System.out.println();
        count = 1;
        for (Square S : squares){
            System.out.println(count +". " + S);
            count++;
        }
    }
}
