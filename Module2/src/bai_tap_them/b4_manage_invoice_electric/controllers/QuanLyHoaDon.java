package bai_tap_them.b4_manage_invoice_electric.controllers;

import java.util.Scanner;

public class QuanLyHoaDon {
    public static void main(String[] args) {
        QuanLyHoaDon.LuaChonChucNang();
    }
    public static void LuaChonChucNang(){
        Scanner scanner = new Scanner(System.in);
        byte choose;
        do{
            try{
                System.out.println("CHƯƠNG TRÌNH QUẢN LÝ HÓA ĐƠN TIỀN ĐIỆN");
                System.out.println("1. Thêm mới khách hàng.\n" +
                        "2. Hiện thị thông tin khách hàng\n" +
                        "3. Tìm kiếm khách hàng\n" +
                        "4. Thêm mới hóa đơn\n" +
                        "5. Chỉnh sửa hóa đơn\n" +
                        "6. Hiện thị thông  tin chi tiết hóa đơn\n" +
                        "7. Thoát");
                System.out.println("Nhập lựa chọn(1~7): ");
                choose = Byte.parseByte(scanner.nextLine());
                switch (choose) {
                    case 1: ChucNang.themMoiKhachHang();break;
                    case 2: ChucNang.hienThiThongTinKhachHang();break;
                    case 3: ChucNang.timKiemKhachHang();break;
                    case 4: ChucNang.themMoiHoaDon();break;
                    case 5: ChucNang.chinhSuaHoaDon();break;
                    case 6: ChucNang.hienThiChiTietHoaDon();break;
                    case 7: System.exit(0); break;
                    default: System.err.println("Vui lòng nhập trong khoảng 1 đến 7");break;
                }
                final String regex = "^\\D$";
                if (Integer.toString(choose).matches(regex)){
                    throw new Exception("Lỗi nhập ");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }while (true);
    }
}
