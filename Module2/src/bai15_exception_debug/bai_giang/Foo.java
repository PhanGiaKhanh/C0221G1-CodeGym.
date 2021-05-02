package bai15_exception_debug.bai_giang;

public class Foo {
    public static void main(String[] args) {
//        try {
//            return;
//        }
//        finally{
//            System.out.println( "Finally" );
//        }
        try {
            int x = 0;
            int y = 5 / x;
        }catch (ArithmeticException e) {
            System.out.println("Arithmetic");
        }catch (Exception ae) {
            System.out.println("ThemThuocTinh");
        }
        System.out.println("finished");
    }
}
