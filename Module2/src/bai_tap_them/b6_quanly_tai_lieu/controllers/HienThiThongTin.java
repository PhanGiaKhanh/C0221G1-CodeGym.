package bai_tap_them.b6_quanly_tai_lieu.controllers;

import bai_tap_them.b6_quanly_tai_lieu.commons.Chung;
import bai_tap_them.b6_quanly_tai_lieu.commons.DocGhiFile;
import bai_tap_them.b6_quanly_tai_lieu.models.Bao;
import bai_tap_them.b6_quanly_tai_lieu.models.Sach;
import bai_tap_them.b6_quanly_tai_lieu.models.TaiLieu;
import bai_tap_them.b6_quanly_tai_lieu.models.TapChi;

import java.util.List;
import java.util.Scanner;

public class HienThiThongTin {
    private static Scanner scanner = new Scanner(System.in);
    public static void danhMuc(){
        String choose = "";
        while (true){
            System.out.println("1.\t Hiển thị tất cả\n" +
                    "2.\t Hiển thị sách\n" +
                    "3.\t Hiển thị tạp chí\n" +
                    "4.\t Hiển thị báo\n" +
                    "5.\t Trở lại" +
                    "6.\t Thoát");
            System.out.println("Chọn chức năng (1-7)");
            choose = new Scanner(System.in).nextLine();
            switch (choose){
                case "1": hienThiTatCa();break;
                case "2": hienThiSach();break;
                case "3": hienThiTapChi();break;
                case "4": hienThiBao();break;
                case "5": return;
                case "6": System.err.println("ĐÃ THOÁT");System.exit(0);break;
                default: System.err.println("Vui lòng nhập từ 1-7");break;
            }
            System.out.println();
        }
    }

    private static void hienThiBao() {
        List<TaiLieu> danhSach = DocGhiFile.docDanhSach("taiLieu.csv");
        System.out.println("Hiển thị tất cả báo");
        System.out.printf("%-5s %-20s %-5s %-15s\n","maTaiLieu","tenNhaSX","soBanPhatHanh","ngayPhatHanh");

        for (TaiLieu taiLieu : danhSach) {
            if (taiLieu instanceof Bao) {
                taiLieu.showInfo();
            }
        }
    }

    private static void hienThiTapChi() {
        List<TaiLieu> danhSach = DocGhiFile.docDanhSach("taiLieu.csv");
        System.out.println("Hiển thị tất cả tạp chí");
        System.out.printf("%-5s %-20s %-5s %-15s %-15s \n","maTaiLieu","tenNhaSX","soBanPhatHanh","soTrangPhatHanh","thangPhatHanh");

        for (TaiLieu tapChi : danhSach) {
            if (tapChi instanceof TapChi) {
               tapChi.showInfo();
            }
        }
    }

    private static void hienThiSach() {
        List<TaiLieu> danhSach = DocGhiFile.docDanhSach("taiLieu.csv");
        System.out.println("Hiển thị tất cả sách");
        System.out.printf("%-5s %-20s %-5s %-15s %-15s \n","maTaiLieu","tenNhaSX","soBanPhatHanh","tenTacGia","soTrang");

        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i) instanceof Sach) {
                danhSach.get(i).showInfo();
            }
        }
    }

    private static void hienThiTatCa() {
        System.out.println("Hello");
        List<TaiLieu> danhSach = DocGhiFile.docDanhSach("taiLieu.csv");
        System.out.println("Hiển thị tất cả tài liệu");
        danhSach.forEach(e->e.showInfo());
        System.out.println();
    }
}
