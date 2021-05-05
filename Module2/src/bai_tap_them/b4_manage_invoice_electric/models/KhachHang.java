package bai_tap_them.b4_manage_invoice_electric.models;

public abstract class KhachHang implements HienThi {
    protected String maKhachHang;
    protected String tenKhachHang;
    public KhachHang() {
    }

    public KhachHang(String maKhachHang, String tenKhachHang) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
    }

    @Override
    public String toString() {
        return maKhachHang +
                "," + tenKhachHang;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }
}
