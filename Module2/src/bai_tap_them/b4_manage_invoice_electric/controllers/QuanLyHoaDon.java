package bai_tap_them.b4_manage_invoice_electric.controllers;

import bai_tap_them.b3_manage_transport3.controllers.Function;

import java.util.Scanner;

public class QuanLyHoaDon {
    public static void main(String[] args) {
        QuanLyHoaDon.LuaChonChucNang();
    }
    public static void LuaChonChucNang() {
        Scanner scanner = new Scanner(System.in);
        byte choose;
        do {
            try {
                System.out.println("CHƯƠNG TRÌNH QUẢN LÝ HÓA ĐƠN TIỀN ĐIỆN\n" +
                        "Chọn chức năng:\n" +
                        "1. Thêm mới khách hàng.\n" +
                        "2. Hiện thị thông tin khách hàng\n" +
                        "3. Tìm kiếm khách hàng\n" +
                        "4. Thêm mới hóa đơn\n" +
                        "5. Chỉnh sửa hóa đơn\n" +
                        "6. Hiện thị thông  tin chi tiết hóa đơn\n" +
                        "7. Thoát\n");
                System.out.println("-------Chọn chức năng (1-7)-------");
                choose = Byte.parseByte(scanner.nextLine());
                switch (choose) {
                    case 1:
                        ChucNang.themMoiKhachHang();
                        break;
                    case 2:
                        ChucNang.hienThiThongTinKhachHang();
                        break;
                    case 3:
                        ChucNang.timKiemKhachHang();
                        break;
                    case 4:
                        ChucNang.themMoiHoaDon();
                        break;
                    case 5:
                        ChucNang.chinhSuaHoaDon();
                        break;
                    case 6:
                        ChucNang.hienThiChiTietHoaDon();
                        break;
                    case 7:
                        System.err.println("ĐÃ THOÁT");
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Vui long nhập từ 1-7");
                        break;
                }
            } catch (Exception e) {
                System.err.println("Lỗi nhập:  " + e);
            }
        } while (true);
    }
}
