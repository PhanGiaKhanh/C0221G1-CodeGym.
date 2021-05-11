package bai_tap_them.b6_quanly_tai_lieu.controllers;

import bai_tap_them.b6_quanly_tai_lieu.commons.Chung;
import bai_tap_them.b6_quanly_tai_lieu.commons.DocGhiFile;
import bai_tap_them.b6_quanly_tai_lieu.commons.tinNhanException;
import bai_tap_them.b6_quanly_tai_lieu.models.Bao;
import bai_tap_them.b6_quanly_tai_lieu.models.Sach;
import bai_tap_them.b6_quanly_tai_lieu.models.TaiLieu;
import bai_tap_them.b6_quanly_tai_lieu.models.TapChi;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NhapThongTin {
    private static Scanner scanner = new Scanner(System.in);
    public static void danhMuc(){
        String choose = "";
        while (true){
            System.out.println("1.\t Nhập thông tin sách\n" +
                    "2.\t Nhập thông tin tạp chí\n" +
                    "3.\t Nhập thông tin báo\n" +
                    "4.\t Trở lại \n" +
                    "5.\t Thoát");
            System.out.println("Chọn chức năng (1-5)");
            choose = scanner.nextLine();
            switch (choose){
                case "1": themSach();break;
                case "2": themTapChi();break;
                case "3": themBao();break;
                case "4": return;
                case "5": System.err.println("ĐÃ THOÁT");System.exit(0);break;
                default: System.err.println("Vui lòng nhập từ 1-5");break;
            }
            System.out.println();
        }
    }

    private static void themBao() {
        String maTaiLieu = themThuocTinh("mã tài liệu", Chung.NAME_E, "vd: A1");
        String tenNhaSX = themThuocTinh("tên nhà sản xuất", Chung.NAME_VN, "vd: Nhà Sách Kim Đồng");
        String soBanPhatHanh = themThuocTinh("số bản phát hành", Chung.NUMBER, "vd: 1");
        String ngayPhatHanh = themThuocTinh("ngày phát hành", Chung.NAME_VN, "vd: Nguyễn Văn A");
        TaiLieu bao = new Bao(maTaiLieu,tenNhaSX,soBanPhatHanh,ngayPhatHanh);
        List<TaiLieu> danhSach = new ArrayList<>();
        danhSach.add(bao);
        DocGhiFile.vetFile("taiLieu.csv",danhSach, true);
    }

    private static void themTapChi() {
        String maTaiLieu = themThuocTinh("mã tài liệu", Chung.NAME_E, "vd: A1");
        String tenNhaSX = themThuocTinh("tên nhà sản xuất", Chung.NAME_VN, "vd: Nhà Sách Kim Đồng");
        String soBanPhatHanh = themThuocTinh("số bản phát hành", Chung.NUMBER, "vd: 1");
        String soTrangPhatHanh = themThuocTinh("số trang phát hành", Chung.NAME_VN, "vd: Nguyễn Văn A");
        String thangPhatHanh = themThuocTinh("tháng phát hành", "^[0-9]$|^1[0-2]$", "vd: 10");
        TaiLieu tapChi = new TapChi(maTaiLieu,tenNhaSX,soBanPhatHanh,soTrangPhatHanh,thangPhatHanh);
        List<TaiLieu> danhSach = new ArrayList<>();
        danhSach.add(tapChi);
        DocGhiFile.vetFile("taiLieu.csv",danhSach, true);
    }

    private static void themSach() {
        String maTaiLieu = themThuocTinh("mã tài liệu", Chung.NAME_E, "vd: A1");
        String tenNhaSX = themThuocTinh("tên nhà sản xuất", Chung.NAME_VN, "vd: Nhà Sách Kim Đồng");
        String soBanPhatHanh = themThuocTinh("số bản phát hành", Chung.NUMBER, "vd: 1");
        String tenTacGia = themThuocTinh("tên tác giả", Chung.NAME_VN, "vd: Nguyễn Văn A");
        String soTrang = themThuocTinh("số trang", Chung.NUMBER, "vd: 10");
        TaiLieu sach = new Sach(maTaiLieu,tenNhaSX,soBanPhatHanh,tenTacGia,soTrang);
        List<TaiLieu> danhSach = new ArrayList<>();
        danhSach.add(sach);
        DocGhiFile.vetFile("taiLieu.csv",danhSach, true);
    }

    public static String themThuocTinh(String thuocTinh, String regex, String tinNhan) {
        String input = null;
        while (true){
            try {
                System.out.println("Nhập " + thuocTinh +  " (vd: " + tinNhan + " )");
                input = scanner.nextLine();
                if (!input.matches(regex)) {
                    throw new tinNhanException("Lỗi định dạng " + thuocTinh + ": " + regex);
                }
                return input;
            } catch (tinNhanException v) {
                System.err.println(v.getMessage());
            }
        }
    }
}
