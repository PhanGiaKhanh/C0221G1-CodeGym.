package bai_tap_them.b4_manage_invoice_electric.models;

public class KhachVietNam extends KhachHang {
    public String loaiKhachHang;
    public String dinhMucTieuThu;

    public KhachVietNam() {
    }

    public KhachVietNam(String loaiKhachHang, String dinhMucTieuThu) {
        this.loaiKhachHang = loaiKhachHang;
        this.dinhMucTieuThu = dinhMucTieuThu;
    }

    public KhachVietNam(String maKhachHang, String tenKhachHang, String loaiKhachHang, String dinhMucTieuThu) {
        super(maKhachHang, tenKhachHang);
        this.loaiKhachHang = loaiKhachHang;
        this.dinhMucTieuThu = dinhMucTieuThu;
    }

    @Override
    public String toString() {
        return maKhachHang +
                "," + tenKhachHang +
                "," + loaiKhachHang +
                "," + dinhMucTieuThu;
    }

    @Override
    public void showInfo() {
        System.out.println("KhachVietNam{" +
                "maKhachHang='" + maKhachHang + '\'' +
                ", tenKhachHang='" + tenKhachHang + '\'' +
                ", loaiKhachHang='" + loaiKhachHang + '\'' +
                ", dinhMucTieuThu='" + dinhMucTieuThu + '\'' +
                '}');
    }
}
