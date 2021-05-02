package bai15_exception_debug.bai_giang;

public class X {
//    public static void main(String [] args)     {
//        try {
//            badMethod();
//            System.out.print("A");
//        }catch (RuntimeException ex){
//            System.out.print("B");
//        }catch (ThemThuocTinh ex1){
//            System.out.print("C");
//        }finally{
//            System.out.print("D");
//        }
//        System.out.print("E");
//    }
//    public static void badMethod(){
//        throw new RuntimeException();
//    }
public static void main(String [] args) {
    try         {
        badMethod();
        System.out.print("A");
    }  catch (Exception ex)  {
        System.out.print("B");
    } finally {
        System.out.print("C");
    }
    System.out.print("D");
}
    public static void badMethod(){
        throw new Error();
    }
}
