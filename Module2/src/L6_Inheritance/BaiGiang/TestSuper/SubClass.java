package L6_Inheritance.BaiGiang.TestSuper;

public class SubClass extends TestSuper {
    private int width;
    private int height;
    public SubClass(String name, int width, int height) {
        super(name);
        this.height = height;
        this.width = width;
    }

    public static void main(String[] args) {
        SubClass subClass = new SubClass("Rectangle", 20,30);
        System.out.println(subClass.height);
        System.out.println(subClass.width);
        System.out.println(subClass.getName());
    }
}
