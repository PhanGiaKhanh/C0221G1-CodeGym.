package bai_tap_them.b3_manage_transport.models;

public class Car extends Vehicle {
    private int soChoNgoi;
    private String kieuXe;

    public Car() {
    }

    public Car(int soChoNgoi, String kieuXe) {
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }

    public Car(String bienKiemTra, String hangSanXuat, int namSanXuat, String chuSoHuu, int soChoNgoi, String kieuXe) {
        super(bienKiemTra, hangSanXuat, namSanXuat, chuSoHuu);
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }

    @Override
    public String toString() {
        return bienKiemSoat +
                "," + hangSanXuat +
                "," + namSanXuat + "," + kieuXe +
                "," + chuSoHuu +
                "," + soChoNgoi
                ;
    }

    @Override
    public void showInfo() {
        System.out.println("Car{" +
                "Kiểu xe=" + kieuXe +
                ", Biển kiểm soát='" + bienKiemSoat + '\'' +
                ", Hãng sản xuất='" + hangSanXuat + '\'' +
                ", Năm sản xuất=" + namSanXuat +
                ", Chủ sở hữu='" + chuSoHuu + '\'' +
                '}');
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public String getKieuXe() {
        return kieuXe;
    }

    public void setKieuXe(String kieuXe) {
        this.kieuXe = kieuXe;
    }
}
