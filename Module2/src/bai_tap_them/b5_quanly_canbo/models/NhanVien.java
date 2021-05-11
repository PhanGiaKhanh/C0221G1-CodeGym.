package bai_tap_them.b5_quanly_canbo.models;

public class NhanVien extends CanBo {
    private String congViec;

    public NhanVien() {
    }

    public NhanVien(String id, String hoTen, String ngaySinh, String gioiTinh, String diaChi, String congViec) {
        super(id, hoTen, ngaySinh, gioiTinh, diaChi);
        this.congViec = congViec;
    }

    @Override
    public String toString() {
        return id +
                ",2," + hoTen +
                "," + ngaySinh +
                "," + gioiTinh +
                "," + diaChi +
                "," + congViec;
    }

    @Override
    public void showInfo() {
        System.out.println("NhanVien{" +
                "id = " + id +
                ", hoTen='" + hoTen + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", congViec='" + congViec + '\'' +
                '}');
    }

    public String getCongViec() {
        return congViec;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }
}
