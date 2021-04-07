package L6_Inheritance.ThucHanh.Shape;

public class Square extends Rectangle {
    private double lenght;

    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }
    public Square(double side, String color, boolean filled){
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    @Override
    public  void setWidth(double width){
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }
    @Override
    public String toString(){
        return "A square with side = "
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }

    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);

        square = new Square(3);
        System.out.println(square);
    }
}