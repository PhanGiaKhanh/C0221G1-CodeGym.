package bai_tap_them.b4_manage_invoice_electric.models;

public class KhachVietNam extends HoaDonTienDIen {
    private String hoTen;
    private String loaiKhach;
    private int dinhMucTieuThu;

    public KhachVietNam() {
    }

    public KhachVietNam(String maKhachHang, String hoTen, String loaiKhach, int dinhMucTieuThu) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
        this.loaiKhach = loaiKhach;
        this.dinhMucTieuThu = dinhMucTieuThu;
    }

    public KhachVietNam(String[] strings, String hoTen, String loaiKhach, int dinhMucTieuThu) {
        super(strings);
        this.hoTen = hoTen;
        this.loaiKhach = loaiKhach;
        this.dinhMucTieuThu = dinhMucTieuThu;
    }

    public KhachVietNam(String[] strings) {
        this.maHoaDon = strings[0];
        this.maKhachHang = strings[1];
        this.ngayRaHoaDon = strings[2];
        this.soLuongTieuThu = Integer.parseInt(strings[3]);
        this.donGia = Double.parseDouble(strings[4]);
        this.thanhTien = Double.parseDouble(strings[5]);
        this.hoTen = strings[6];
        this.loaiKhach = strings[7];
        this.dinhMucTieuThu = Integer.parseInt(strings[8]);
    }

    public KhachVietNam(String maHoaDon, String maKhachHang, String ngayRaHoaDon, int soLuongTieuThu, double donGia, double thanhTien, String hoTen, String loaiKhach, int dinhMucTieuThu) {
        super(maHoaDon, maKhachHang, ngayRaHoaDon, soLuongTieuThu, donGia, thanhTien);
        this.hoTen = hoTen;
        this.loaiKhach = loaiKhach;
        this.dinhMucTieuThu = dinhMucTieuThu;
    }

    @Override
    public String toString() {
        return  hoTen +
                "," + loaiKhach +
                "," + dinhMucTieuThu +
                "," + maHoaDon +
                "," + maKhachHang +
                "," + ngayRaHoaDon +
                "," + soLuongTieuThu +
                "," + donGia +
                "," + thanhTien;
    }

    @Override
    public void showInfo() {
        System.out.println("KhachVietNam{" +
                "hoTen='" + hoTen + '\'' +
                ", loaiKhach='" + loaiKhach + '\'' +
                ", dinhMucTieuThu=" + dinhMucTieuThu +
                ", maHoaDon='" + maHoaDon + '\'' +
                ", maKhachHang='" + maKhachHang + '\'' +
                ", ngayRaHoaDon='" + ngayRaHoaDon + '\'' +
                ", soLuongTieuThu=" + soLuongTieuThu +
                ", donGia=" + donGia +
                ", thanhTien=" + thanhTien +
                '}');
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getLoaiKhach() {
        return loaiKhach;
    }

    public void setLoaiKhach(String loaiKhach) {
        this.loaiKhach = loaiKhach;
    }

    public int getDinhMucTieuThu() {
        return dinhMucTieuThu;
    }

    public void setDinhMucTieuThu(int dinhMucTieuThu) {
        this.dinhMucTieuThu = dinhMucTieuThu;
    }
}
