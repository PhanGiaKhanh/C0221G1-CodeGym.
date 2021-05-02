package bai_tap_them.b3_manage_transport2.models;

public class XeTai extends PhuongTien {
    private double trongTai;

    public XeTai() {
    }

    public XeTai(String bienKiemSoat, String tenHangSX, int namSX, String chuSoHuu, double trongTai) {
        super(bienKiemSoat, tenHangSX, namSX, chuSoHuu);
        this.trongTai = trongTai;
    }
    public XeTai(String[] list) {
        super(list);
        this.trongTai = Double.parseDouble(list[4]);
    }
    @Override
    public String toString() {
        return bienKiemSoat +
                "," + tenHangSX +
                "," + namSX +
                "," + chuSoHuu +
                "," + trongTai;
    }

    @Override
    public void showInfo() {
        System.out.println("XeTai{" +
                "bienKiemSoat='" + bienKiemSoat + '\'' +
                ", tenHangSX='" + tenHangSX + '\'' +
                ", namSX=" + namSX +
                ", chuSoHuu='" + chuSoHuu + '\'' +
                ",trongTai=" +trongTai +
                '}');
    }

    public double getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(double trongTai) {
        this.trongTai = trongTai;
    }

}
