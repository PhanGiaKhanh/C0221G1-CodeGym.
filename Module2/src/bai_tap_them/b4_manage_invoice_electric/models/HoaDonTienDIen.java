package bai_tap_them.b4_manage_invoice_electric.models;

public abstract class HoaDonTienDIen {
    protected String maHoaDon;
    protected String maKhachHang;
    protected String ngayRaHoaDon;
    protected int soLuongTieuThu;
    protected double donGia;
    protected double thanhTien;

    public HoaDonTienDIen() {
    }
    public HoaDonTienDIen(String[] strings){
        this.maHoaDon = strings[0];
        this.maKhachHang = strings[1];
        this.ngayRaHoaDon = strings[2];
        this.soLuongTieuThu = Integer.parseInt(strings[3]);
        this.donGia = Double.parseDouble(strings[4]);
        this.thanhTien = Double.parseDouble(strings[5]);
    }
    public HoaDonTienDIen(String maHoaDon, String maKhachHang, String ngayRaHoaDon, int soLuongTieuThu, double donGia, double thanhTien) {
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.ngayRaHoaDon = ngayRaHoaDon;
        this.soLuongTieuThu = soLuongTieuThu;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return  maHoaDon +
                "," + maKhachHang +
                "," + ngayRaHoaDon +
                "," + soLuongTieuThu +
                "," + donGia +
                "," + thanhTien;
    }

    public abstract void showInfo();

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getNgayRaHoaDon() {
        return ngayRaHoaDon;
    }

    public void setNgayRaHoaDon(String ngayRaHoaDon) {
        this.ngayRaHoaDon = ngayRaHoaDon;
    }

    public int getSoLuongTieuThu() {
        return soLuongTieuThu;
    }

    public void setSoLuongTieuThu(int soLuongTieuThu) {
        this.soLuongTieuThu = soLuongTieuThu;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
}
