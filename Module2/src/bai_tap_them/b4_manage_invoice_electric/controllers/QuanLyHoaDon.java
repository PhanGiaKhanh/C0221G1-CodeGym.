package bai_tap_them.b4_manage_invoice_electric.controllers;

import bai_tap_them.b4_manage_invoice_electric.commons.TapTin;
import bai_tap_them.b4_manage_invoice_electric.models.KhachHang;

import java.util.List;
import java.util.Scanner;

public class QuanLyHoaDon {
    public static void main(String[] args) {
        QuanLyHoaDon.LuaChonChucNang();
    }
    public static void LuaChonChucNang() {
        Scanner scanner = new Scanner(System.in);
        String choose;
        while (true) {
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
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    ThemMoiKhachHang.danhMucThem();
                    break;
                case "2":
                    HienThiTHongTinKH.tatCaKachHang();
                    break;
                case "3":
                    timKiemKhachHang();
                    break;
                case "4":
                    ThemHoaDon.danhSach();
                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "7":
                    System.err.println("ĐÃ THOÁT");
                    System.exit(0);
                default:
                    System.err.println("Vui long nhập từ 1-7");
                    break;
            }
        }
    }


    private static void timKiemKhachHang() {
        String tenKH = ThemMoiKhachHang.add("tên khách hàng", Chung.NAME);
        List<KhachHang> lists = TapTin.docKhachHang("khachHang.csv");
        for (KhachHang li : lists) {
            if(li.getTenKhachHang().equals(tenKH)){
                li.showInfo();
                System.out.println();
                return;
            }
        }
        System.err.println("Tên bạn nhập không tồn tại\n");
    }
}
