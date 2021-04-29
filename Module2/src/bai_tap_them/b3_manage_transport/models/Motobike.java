package bai_tap_them.b3_manage_transport.models;

public class Motobike extends Vehicle {
    private String trongTai;

    public Motobike() {
    }

    public Motobike(String trongTai) {
        this.trongTai = trongTai;
    }

    public Motobike(String bienKiemTra, String hangSanXuat, int namSanXuat, String chuSoHuu, String trongTai) {
        super(bienKiemTra, hangSanXuat, namSanXuat, chuSoHuu);
        this.trongTai = trongTai;
    }

    @Override
    public String toString() {
        return bienKiemSoat +
                "," + hangSanXuat +
                "," + namSanXuat +
                "," + chuSoHuu +
                "," + trongTai;
    }

    @Override
    public void showInfo() {
        System.out.println("Xe máy {" +
                "Trọng tải=" + trongTai +
                ", Biển kiểm soát='" + bienKiemSoat + '\'' +
                ", Hãng sản xuất='" + hangSanXuat + '\'' +
                ", Năm sản xuất=" + namSanXuat +
                ", Chủ sở hữu='" + chuSoHuu + '\'' +
                '}');
    }

    public String getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(String trongTai) {
        this.trongTai = trongTai;
    }
}
