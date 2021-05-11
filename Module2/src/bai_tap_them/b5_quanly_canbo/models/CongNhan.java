package bai_tap_them.b5_quanly_canbo.models;

public class CongNhan extends CanBo {
    private String bacCongNhan;

    public CongNhan() {
    }

    public CongNhan(String id, String hoTen, String ngaySinh, String gioiTinh, String diaChi, String bacCongNhan) {
        super(id, hoTen, ngaySinh, gioiTinh, diaChi);
        this.bacCongNhan = bacCongNhan;
    }

    @Override
    public String toString() {
        return id +
                ",3," + hoTen +
                "," + ngaySinh +
                "," + gioiTinh +
                "," + diaChi +
                "," + bacCongNhan;
    }

    @Override
    public void showInfo() {
        System.out.println("CongNhan{" +
                "id = " + id +
                ", hoTen='" + hoTen + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", bacCongNhan='" + bacCongNhan + '\'' +
                '}');
    }

    public String getBacCongNhan() {
        return bacCongNhan;
    }

    public void setBacCongNhan(String bacCongNhan) {
        this.bacCongNhan = bacCongNhan;
    }
}
