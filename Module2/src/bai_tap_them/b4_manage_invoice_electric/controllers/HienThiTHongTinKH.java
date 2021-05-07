package bai_tap_them.b4_manage_invoice_electric.controllers;

import bai_tap_them.b4_manage_invoice_electric.commons.TapTin;
import bai_tap_them.b4_manage_invoice_electric.models.KhachHang;

import java.util.List;

public class HienThiTHongTinKH {
    public static void tatCaKachHang() {
        List<KhachHang> khachHangs = TapTin.docKhachHang("khachHang.csv");
        for (int i = 0; i < khachHangs.size(); i++) {
            System.out.print((i + 1) + ". ");
            khachHangs.get(i).showInfo();
        }
    }
}
