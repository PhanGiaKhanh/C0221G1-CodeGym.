package bai_tap_them.b3_manage_transport2.commons;

import bai_tap_them.b3_manage_transport2.models.Oto;
import bai_tap_them.b3_manage_transport2.models.PhuongTien;
import bai_tap_them.b3_manage_transport2.models.XeMay;
import bai_tap_them.b3_manage_transport2.models.XeTai;

public class ThemMoi {
    public static void xeTai(){
        String bienKiemSoat = ThemThuocTinh.bienKiemSoat(ThemThuocTinh.DINHDANG_XETAI);
        String tenHangSX = ThemThuocTinh.tenHangSX();
        int namSX = ThemThuocTinh.namSX();
        String chuSoHuu = ThemThuocTinh.chuSoHuu();
        double trongTai = ThemThuocTinh.trongTai();
        PhuongTien xeTai = new XeTai(bienKiemSoat,tenHangSX,namSX,chuSoHuu,trongTai);
        TapTin.viet(xeTai.toString());
    }
    public static void oto(){
        String bienKiemSoat = ThemThuocTinh.bienKiemSoat(ThemThuocTinh.DINHDANG_OTO);
        String tenHangSX = ThemThuocTinh.tenHangSX();
        int namSX = ThemThuocTinh.namSX();
        String chuSoHuu = ThemThuocTinh.chuSoHuu();
        int soChoNgoi = ThemThuocTinh.soChoNgoi();
        String kieuXe = bienKiemSoat.contains("A")? "Du lịch" : "Xe khách";
        PhuongTien oto = new Oto(bienKiemSoat,tenHangSX,namSX,chuSoHuu,soChoNgoi,kieuXe);
        TapTin.viet(oto.toString());
    }
    public static void xeMay(){
        String bienKiemSoat = ThemThuocTinh.bienKiemSoat(ThemThuocTinh.DINHDANG_XEMAY);
        String tenHangSX = ThemThuocTinh.tenHangSX();
        int namSX = ThemThuocTinh.namSX();
        String chuSoHuu = ThemThuocTinh.chuSoHuu();
        double congSuat = ThemThuocTinh.congSuat();
        PhuongTien xeMay = new XeMay(bienKiemSoat,tenHangSX,namSX,chuSoHuu,congSuat);
        TapTin.viet(xeMay.toString());
    }
}
