package bai_tap_them.b6_quanly_tai_lieu.models;

public abstract class TaiLieu {
    protected String maTaiLieu;
    protected String tenNhaSX;
    protected String soBanPhatHanh;

    public TaiLieu() {
    }

    public TaiLieu(String maTaiLieu, String tenNhaSX, String soBanPhatHanh) {
        this.maTaiLieu = maTaiLieu;
        this.tenNhaSX = tenNhaSX;
        this.soBanPhatHanh = soBanPhatHanh;
    }

    public abstract void showInfo();

    @Override
    public String toString() {
        return "TaiLieu{" +
                "maTaiLieu='" + maTaiLieu + '\'' +
                ", tenNhaSX='" + tenNhaSX + '\'' +
                ", soBanPhatHanh='" + soBanPhatHanh + '\'' +
                '}';
    }

    public String getMaTaiLieu() {
        return maTaiLieu;
    }

    public void setMaTaiLieu(String maTaiLieu) {
        this.maTaiLieu = maTaiLieu;
    }

    public String getTenNhaSX() {
        return tenNhaSX;
    }

    public void setTenNhaSX(String tenNhaSX) {
        this.tenNhaSX = tenNhaSX;
    }

    public String getSoBanPhatHanh() {
        return soBanPhatHanh;
    }

    public void setSoBanPhatHanh(String soBanPhatHanh) {
        this.soBanPhatHanh = soBanPhatHanh;
    }
}
