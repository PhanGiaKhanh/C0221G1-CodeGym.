package bai_tap_them.b3_manage_transport.models;

public class Truck extends Vehicle {
    private double congSuat;

    public Truck() {
    }

    public Truck(double congSuat) {
        this.congSuat = congSuat;
    }

    public Truck(String bienKiemTra, String hangSanXuat, int namSanXuat, String chuSoHuu, double congSuat) {
        super(bienKiemTra, hangSanXuat, namSanXuat, chuSoHuu);
        this.congSuat = congSuat;
    }

    @Override
    public String toString() {
        return
                bienKiemSoat +
                        "," + hangSanXuat +
                        "," + namSanXuat +
                        "," + chuSoHuu +
                        "," + congSuat;
    }

    @Override
    public void showInfo() {
        System.out.println("Xe tải{" +
                "Công suất=" + congSuat +
                ", Biển kiểm soát='" + bienKiemSoat + '\'' +
                ", Hãng sản xuất='" + hangSanXuat + '\'' +
                ", Năm sản xuất=" + namSanXuat +
                ", Chủ sở hữu='" + chuSoHuu + '\'' +
                '}');
    }

    public double getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(double congSuat) {
        this.congSuat = congSuat;
    }
}
