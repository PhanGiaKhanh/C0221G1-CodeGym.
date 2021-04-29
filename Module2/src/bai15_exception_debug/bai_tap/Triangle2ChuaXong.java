package bai15_exception_debug.bai_tap;

import java.util.Scanner;

public class Triangle2ChuaXong {
    public static void main(String[] args) {
        Triangle2ChuaXong triangle2ChuaXong = new Triangle2ChuaXong();
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                int a = Integer.parseInt(scanner.nextLine());
                int b = Integer.parseInt(scanner.nextLine());
                int c = Integer.parseInt(scanner.nextLine());
//                triangle2ChuaXong.checkTrangle(a, b, c);
                if (a<0) {
                    throw new IllegalTriangleException("");
                }
                break;
            } catch (IllegalTriangleException e) {
//            e.printStackTrace(); in lỗi màu đỏ
                System.out.println(" lỗi " + e);
//            System.out.println(e.getMessage());//in ra tin nhan loi
            }
//            catch (Validate e){
//                System.out.println("Lỗi nhập dữ liệu tại  " + e);
//            }
            catch (NumberFormatException e){
                System.err.println("Lỗi nhập dữ liệu tại  " + e);
            }
        }
    }

    public void checkTrangle(double side1, double side2, double side3) throws IllegalTriangleException {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new IllegalTriangleException(" giá trị nhập vào là số âm ");
        }
        if (side1 + side2 < side3 || side2 + side3 < side1 || side1 + side3 < side2) {
            throw new IllegalTriangleException(" tổng 2 cạnh không lớn hơn cạnh còn lại ");
        }


    }
}
