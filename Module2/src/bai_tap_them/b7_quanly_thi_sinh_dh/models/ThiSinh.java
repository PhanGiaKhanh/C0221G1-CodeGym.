package bai_tap_them.b7_quanly_thi_sinh_dh.models;

public abstract class ThiSinh {
    protected String soBaoDanh;
    protected String hoten;
    protected String diaChi;
    protected String uuTien;

    public ThiSinh() {
    }

    public ThiSinh(String soBaoDanh, String hoten, String diaChi, String uuTien) {
        this.soBaoDanh = soBaoDanh;
        this.hoten = hoten;
        this.diaChi = diaChi;
        this.uuTien = uuTien;
    }

    public abstract void showInfo();

    @Override
    public String toString() {
        return "ThiSinh{" +
                "soBaoDanh='" + soBaoDanh + '\'' +
                ", hoten='" + hoten + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", uuTien='" + uuTien + '\'' +
                '}';
    }

    public String getSoBaoDanh() {
        return soBaoDanh;
    }

    public void setSoBaoDanh(String soBaoDanh) {
        this.soBaoDanh = soBaoDanh;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getUuTien() {
        return uuTien;
    }

    public void setUuTien(String uuTien) {
        this.uuTien = uuTien;
    }
}
