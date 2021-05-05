package bai_tap_them.b4_manage_invoice_electric.models;

public class HoaDonTienDIen implements HienThi {
    protected String maHoaDon;
    protected String maKhachHang;
    protected String ngayRaHoaDon;
    protected double soLuongTieuThu;
    protected double donGia;
    protected double thanhTien;

    public HoaDonTienDIen() {
    }

    public HoaDonTienDIen(String maHoaDon, String maKhachHang, String ngayRaHoaDon, double soLuongTieuThu, double donGia, double thanhTien) {
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.ngayRaHoaDon = ngayRaHoaDon;
        this.soLuongTieuThu = soLuongTieuThu;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return maHoaDon +
                "," + maKhachHang +
                "," + ngayRaHoaDon +
                "," + soLuongTieuThu +
                "," + donGia +
                "," + thanhTien;
    }

    @Override
    public void showInfo() {
        System.out.println("HoaDonTienDIen{" +
                "maHoaDon='" + maHoaDon + '\'' +
                ", maKhachHang='" + maKhachHang + '\'' +
                ", ngayRaHoaDon='" + ngayRaHoaDon + '\'' +
                ", soLuongTieuThu=" + soLuongTieuThu +
                ", donGia=" + donGia +
                ", thanhTien=" + thanhTien +
                '}');
    }
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

    public double getSoLuongTieuThu() {
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
