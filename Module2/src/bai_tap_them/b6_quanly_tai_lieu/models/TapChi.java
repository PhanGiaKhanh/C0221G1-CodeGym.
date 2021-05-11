package bai_tap_them.b6_quanly_tai_lieu.models;

import jdk.swing.interop.SwingInterOpUtils;

public class TapChi extends TaiLieu {
    private String soTrangPhatHanh;
    private String thangPhatHanh;

    public TapChi() {
    }

    public TapChi(String soTrangPhatHanh, String thangPhatHanh) {
        this.soTrangPhatHanh = soTrangPhatHanh;
        this.thangPhatHanh = thangPhatHanh;
    }

    public TapChi(String maTaiLieu, String tenNhaSX, String soBanPhatHanh, String soTrangPhatHanh, String thangPhatHanh) {
        super(maTaiLieu, tenNhaSX, soBanPhatHanh);
        this.soTrangPhatHanh = soTrangPhatHanh;
        this.thangPhatHanh = thangPhatHanh;
    }

    @Override
    public String toString() {
        return maTaiLieu +
                ",2," + tenNhaSX +
                "," + soBanPhatHanh +
                "," + soTrangPhatHanh +
                "," + thangPhatHanh;
    }

    @Override
    public void showInfo() {
        System.out.printf("%-5s %-20s %-5s %-15s %-15s \n",maTaiLieu,tenNhaSX,soBanPhatHanh,soTrangPhatHanh,thangPhatHanh);
    }

    public String getSoTrangPhatHanh() {
        return soTrangPhatHanh;
    }

    public void setSoTrangPhatHanh(String soTrangPhatHanh) {
        this.soTrangPhatHanh = soTrangPhatHanh;
    }

    public String getThangPhatHanh() {
        return thangPhatHanh;
    }

    public void setThangPhatHanh(String thangPhatHanh) {
        this.thangPhatHanh = thangPhatHanh;
    }
}
