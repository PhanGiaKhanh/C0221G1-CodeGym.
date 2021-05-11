package bai_tap_them.b5_quanly_canbo.models;

public abstract class CanBo {
    protected String id;
    protected String hoTen;
    protected String ngaySinh;
    protected String gioiTinh;
    protected String diaChi;

    public CanBo() {
    }

    public CanBo(String id, String hoTen, String ngaySinh, String gioiTinh, String diaChi) {
        this.id = id;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
    }

    public CanBo(String id, String loaiCB, String hoTen, String ngaySinh, String gioiTinh, String diaChi) {
    }

    @Override
    public String toString() {
        return id +
                "," + hoTen +
                "," + ngaySinh +
                "," + gioiTinh +
                "," + diaChi;
    }

    public abstract void showInfo();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }


}
