package bai_tap_them.b7_quanly_thi_sinh_dh.models;

public class ThiSinhKhoiC extends ThiSinh {
    private String van;
    private String su;
    private String dia;

    public ThiSinhKhoiC() {
    }

    public ThiSinhKhoiC(String van, String su, String dia) {
        this.van = van;
        this.su = su;
        this.dia = dia;
    }

    public ThiSinhKhoiC(String soBaoDanh, String hoten, String diaChi, String uuTien, String van, String su, String dia) {
        super(soBaoDanh, hoten, diaChi, uuTien);
        this.van = van;
        this.su = su;
        this.dia = dia;
    }

    @Override
    public String toString() {
        return soBaoDanh +
                ",3," + hoten +
                "," + diaChi +
                "," + uuTien +
                "," + van +
                "," + su +
                "," + dia;
    }

    @Override
    public void showInfo() {
        System.out.println("ThiSinhKhoiC{" +
                "soBaoDanh='" + soBaoDanh + '\'' +
                ", hoten='" + hoten + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", uuTien='" + uuTien + '\'' +
                ", van='" + van + '\'' +
                ", su='" + su + '\'' +
                ", dia='" + dia + '\'' +
                '}');
    }

    public String getVan() {
        return van;
    }

    public void setVan(String van) {
        this.van = van;
    }

    public String getSu() {
        return su;
    }

    public void setSu(String su) {
        this.su = su;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
}
