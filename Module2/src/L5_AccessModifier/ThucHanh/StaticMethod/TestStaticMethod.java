package L5_AccessModifier.ThucHanh.StaticMethod;

public class TestStaticMethod {
    public static void main(String[] args) {
//        Student.change();

        Student s1 = new Student(111, "Hoàng");
        Student s2 = new Student(222, "Khanh");
        Student s3 = new Student(333, "Nam");
//        s1.change();
        s1.display();
//        s1.change();
//        Student.change(); //  error lỗi Student.change() phải có static
        s2.display();
        s3.display();
    }
}
