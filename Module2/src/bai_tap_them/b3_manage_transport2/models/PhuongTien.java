package bai_tap_them.b3_manage_transport2.models;

public abstract class PhuongTien {
    protected String bienKiemSoat;
    protected String tenHangSX;
    protected int namSX;
    protected String chuSoHuu;

    public PhuongTien() {
    }
    public PhuongTien(String[] list) {
        this.bienKiemSoat = list[0];
        this.tenHangSX = list[1];
        this.namSX = Integer.parseInt(list[2]);
        this.chuSoHuu = list[3];
    }
    public PhuongTien(String bienKiemSoat, String tenHangSX, int namSX, String chuSoHuu) {
        this.bienKiemSoat = bienKiemSoat;
        this.tenHangSX = tenHangSX;
        this.namSX = namSX;
        this.chuSoHuu = chuSoHuu;
    }

    @Override
    public String toString() {
        return bienKiemSoat +
                "," + tenHangSX +
                "," + namSX +
                "," + chuSoHuu;
    }

    public abstract void showInfo();

    public String getBienKiemSoat() {
        return bienKiemSoat;
    }

    public void setBienKiemSoat(String bienKiemSoat) {
        this.bienKiemSoat = bienKiemSoat;
    }

    public String getTenHangSX() {
        return tenHangSX;
    }

    public void setTenHangSX(String tenHangSX) {
        this.tenHangSX = tenHangSX;
    }

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

    public String getChuSoHuu() {
        return chuSoHuu;
    }

    public void setChuSoHuu(String chuSoHuu) {
        this.chuSoHuu = chuSoHuu;
    }
}
