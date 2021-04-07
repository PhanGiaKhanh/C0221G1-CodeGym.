package bai7_abstract_class_interface;

public class Test {
    public abstract class Hinh{
        private String hello;

        protected Hinh() {
        }
    }

    class Tron extends Hinh{}

    abstract class DaGiac extends Hinh{}

    class TamGiac extends DaGiac{}

    class ChuNhat extends DaGiac{}

    public  void main(String[] args) {

//        Hinh h1 = new Tron();
//        Hinh h2 = new DaGiac();
//         Hinh h4 = new ChuNhat();
//        Hinh h3 = new TamGiac();
// Dagiac ko thể gọi pthuc abstract của lớp cha abs

//        TamGiac h3 = new TamGiac();
//        Hinh h2 = new TamGiac();
//        TamGiac h4 = new TamGiac();
//        Hinh h1 = new Hinh();//
// ko thể tạo ob từ class abstract
    }
}
