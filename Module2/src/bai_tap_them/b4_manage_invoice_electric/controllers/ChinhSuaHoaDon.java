package bai_tap_them.b4_manage_invoice_electric.controllers;

import bai_tap_them.b4_manage_invoice_electric.commons.TapTin;
import bai_tap_them.b4_manage_invoice_electric.models.HoaDonTienDIen;

import java.util.List;
import java.util.Scanner;

public class ChinhSuaHoaDon {
    public static void main(String[] args) {
        hienThi();
    }
    public static void hienThi(){
        HoaDonTienDIen hoaDonTienDIen;
        int viTri;
        while (true) {
            List<String> list = TapTin.docHoaDon("hoaDon.csv");
            for (int i = 0; i < list.size(); i++) {
                System.out.print((i + 1) + ". ");
                System.out.println(list.get(i));
            }
            System.out.println("chọn 1-" + list.size());
            String chon = new Scanner(System.in).nextLine();
            if (Integer.parseInt(chon) >= 1 && Integer.parseInt(chon) <= list.size()) {
                String[] array = list.get(Integer.parseInt(chon)).split(",");
                viTri = Integer.parseInt(chon)-1;
                hoaDonTienDIen = new HoaDonTienDIen(array[0],array[1],array[2],Double.parseDouble(array[3]),Double.parseDouble(array[4]),Double.parseDouble(array[5]));
                break;
            }
        }

        hoaDonTienDIen.setMaHoaDon(new Scanner(System.in).nextLine());
        hoaDonTienDIen.setMaKhachHang(new Scanner(System.in).nextLine());
        hoaDonTienDIen.setNgayRaHoaDon(new Scanner(System.in).nextLine());
        hoaDonTienDIen.setSoLuongTieuThu(Double.parseDouble(new Scanner(System.in).nextLine()));
    }
}
