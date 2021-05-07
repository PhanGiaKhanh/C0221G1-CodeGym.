package bai_tap_them.b4_manage_invoice_electric.controllers;

import bai_tap_them.b4_manage_invoice_electric.commons.TapTin;
import bai_tap_them.b4_manage_invoice_electric.models.HoaDonTienDIen;
import bai_tap_them.b4_manage_invoice_electric.models.KhachHang;
import bai_tap_them.b4_manage_invoice_electric.models.KhachVietNam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThemHoaDon {

    public static void danhSach() {
        KhachHang khachHang = chonKhachHang();
        String maKhachHang = chonKhachHang().getMaKhachHang();
        String maHoaDon = maHoaDon();
        String ngayRaHoaDon = ThemMoiKhachHang.add("ngày ra hóa đơn", "^(?:(?:31(\\/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
        double soLuongTieuThu = Double.parseDouble(ThemMoiKhachHang.add("số lượng tiêu thụ", "^[0-9]+(.[0-9]+)?$" ));
        double donGia = Double.parseDouble(ThemMoiKhachHang.add("đơn giá", "^[0-9]+(.[0-9]+)?$" ));
        double thanhTien = 0;
        if(maKhachHang.contains("KHVN")){
            double dinhMuc = Double.parseDouble(((KhachVietNam)khachHang).getDinhMucTieuThu());
            if (soLuongTieuThu<=dinhMuc){
                thanhTien = soLuongTieuThu * donGia;
            } else {
                thanhTien = soLuongTieuThu * donGia * dinhMuc + dinhMuc * donGia * 2.5;
            }
        }else if (maKhachHang.contains("KHNN")){
            thanhTien = soLuongTieuThu * donGia;
        }
        HoaDonTienDIen hoaDonTienDien = new HoaDonTienDIen(maKhachHang,maKhachHang,ngayRaHoaDon,soLuongTieuThu,donGia,thanhTien);
        List<HoaDonTienDIen> list= new ArrayList<>();
        list.add(hoaDonTienDien);
        TapTin.viet("hoaDon.csv", list, true);
    }

    private static double thanhTien(String maKhachHang, double soLuongTieuThu, double donGia) {
        double thanhTien = 0;
        if(maKhachHang.contains("KHVN")){
            double dinhMuc = Double.parseDouble(((KhachVietNam)chonKhachHang()).getDinhMucTieuThu());
            if (soLuongTieuThu<=dinhMuc){
                thanhTien = soLuongTieuThu * donGia;
            } else {
                thanhTien = soLuongTieuThu * donGia * dinhMuc + dinhMuc * donGia * 2.5;
            }
        }else if (maKhachHang.contains("KHNN")){
            thanhTien = soLuongTieuThu * donGia;
        }
        return thanhTien;
    }

    public static String maHoaDon() {
        String ma = "MHD-";
        String regex = "^MHD-[0-9]{3}$";
        List<String> lists = TapTin.docHoaDon("hoaDon.csv");
        String id = "";
        System.out.println(lists.size());
        while (true) {
            id = ma + (lists.size() + 1);
            if (id.matches(regex)) {
                break;
            }
            ma += 0;
            id = "";
        }
        return id;
    }
    private static KhachHang chonKhachHang() {
        KhachHang khachHang;
        while (true) {
            List<KhachHang> khachHangList = TapTin.docKhachHang("khachHang.csv");
            List<String> array = new ArrayList<>();
            System.out.println("Danh sách khách hàng");
            for (int i = 0; i < khachHangList.size(); i++) {
                array.add((i + 1) + "");
                System.out.println((i + 1) + ". ");
                khachHangList.get(i).showInfo();
            }
            System.out.println("Chọn lựa 1-" + khachHangList.size());
            String chon = new Scanner(System.in).nextLine();
            if (array.contains(chon)) {
                return khachHang = khachHangList.get(Integer.parseInt(chon)-1);
            } else {
                System.out.println("Không có lựa chọn của bạn: " + chon);
            }
        }
    }
}
