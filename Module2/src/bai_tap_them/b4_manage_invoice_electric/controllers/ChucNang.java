package bai_tap_them.b4_manage_invoice_electric.controllers;

import java.util.Scanner;

public class ChucNang {
    private static Scanner scanner = new Scanner(System.in);
    public static void themMoiKhachHang(){
        byte choose;
        do {
            try {
                System.out.println("1. Thêm khách hàng VN\n" +
                        "2. Thêm khách hàng nước ngoài \n" +
                        "3. Quay lại\n" +
                        "4. Thoát");
                System.out.println("Nhập lựa chọn(1-4): ");
                choose = Byte.parseByte(scanner.nextLine());
                switch (choose){
                    case 1:
                    case 2:
                    case 3: return;
                    case 4: System.exit(0);
                    default:
                        System.err.println("Vui lòng nhập trong khoảng 1~4");break;
                }
                if (String.valueOf(choose).matches("^\\D$")){
                    throw new Exception("Lỗi chương trình");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }while (true);
    }
    public static void hienThiThongTinKhachHang(){

    }
    public static void timKiemKhachHang(){

    }
    public static void themMoiHoaDon(){

    }
    public static void chinhSuaHoaDon(){

    }
    public static void hienThiChiTietHoaDon(){

    }
}
