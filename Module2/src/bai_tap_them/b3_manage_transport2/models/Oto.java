package bai_tap_them.b3_manage_transport2.models;

public class Oto extends PhuongTien {
    private int soChoNgoi;
    private String kieuXe;

    public Oto() {
    }

    public Oto(String bienKiemSoat, String tenHangSX,
               int namSX, String chuSoHuu, int soChoNgoi, String kieuXe) {
        super(bienKiemSoat, tenHangSX, namSX, chuSoHuu);
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }
    public Oto(String[] list) {
        super(list);
        this.soChoNgoi = Integer.parseInt(list[4]);
        this.kieuXe = list[5];
    }

    @Override
    public String toString() {
        return bienKiemSoat +
                "," + tenHangSX +
                "," + namSX +
                "," + chuSoHuu +
                "," + soChoNgoi+
                "," + kieuXe;
    }

    @Override
    public void showInfo() {
        System.out.println("Oto{" +
                "bienKiemSoat='" + bienKiemSoat + '\'' +
                ", tenHangSX='" + tenHangSX + '\'' +
                ", namSX=" + namSX +
                ", kieuXe='" + kieuXe + '\'' +
                ", chuSoHuu='" + chuSoHuu + '\'' +
                ", soChoNgoi=" + soChoNgoi +
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
