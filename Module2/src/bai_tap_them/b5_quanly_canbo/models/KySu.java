package bai_tap_them.b5_quanly_canbo.models;

public class KySu extends CanBo{
    private String nganhDaoTao;

    public KySu() {
    }

    public KySu(String nganhDaoTao) {
        this.nganhDaoTao = nganhDaoTao;
    }

    public KySu(String id, String hoTen, String ngaySinh, String gioiTinh, String diaChi, String nganhDaoTao) {
        super(id, hoTen, ngaySinh, gioiTinh, diaChi);
        this.nganhDaoTao = nganhDaoTao;
    }

    @Override
    public String toString() {
        return id +
                "," + hoTen +
                "," + ngaySinh +
                "," + gioiTinh +
                "," + diaChi +
                "," + nganhDaoTao;
    }

    @Override
    public void showInfo() {
        System.out.println("KySu{" +
                "id = " + id +
                "hoTen='" + hoTen + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", nganhDaoTao='" + nganhDaoTao + '\'' +
                '}');
    }

    public String getNganhDaoTao() {
        return nganhDaoTao;
    }

    public void setNganhDaoTao(String nganhDaoTao) {
        this.nganhDaoTao = nganhDaoTao;
    }
}
