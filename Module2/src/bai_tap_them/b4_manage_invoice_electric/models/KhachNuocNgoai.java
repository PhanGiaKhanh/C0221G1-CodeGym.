package bai_tap_them.b4_manage_invoice_electric.models;

public class KhachNuocNgoai extends HoaDonTienDIen {
    private String hoTen;
    private String quocTich;

    public KhachNuocNgoai() {
    }

    public KhachNuocNgoai(String[] strings) {
        this.maHoaDon = strings[0];
        this.maKhachHang = strings[1];
        this.ngayRaHoaDon = strings[2];
        this.soLuongTieuThu = Integer.parseInt(strings[3]);
        this.donGia = Double.parseDouble(strings[4]);
        this.thanhTien = Double.parseDouble(strings[5]);
        this.hoTen = strings[6];
        this.quocTich = strings[7];
    }

    public KhachNuocNgoai(String maHoaDon, String maKhachHang, String ngayRaHoaDon, int soLuongTieuThu, double donGia, double thanhTien, String hoTen, String quocTich) {
        super(maHoaDon, maKhachHang, ngayRaHoaDon, soLuongTieuThu, donGia, thanhTien);
        this.hoTen = hoTen;
        this.quocTich = quocTich;
    }

    @Override
    public String toString() {
        return hoTen +
                "," + quocTich +
                "," + maHoaDon +
                "," + maKhachHang +
                "," + ngayRaHoaDon +
                "," + soLuongTieuThu +
                "," + donGia +
                "," + thanhTien;
    }

    @Override
    public void showInfo() {
        System.out.println("KhachNuocNgoai{" +
                "hoTen='" + hoTen + '\'' +
                ", quocTich='" + quocTich + '\'' +
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

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }
}
