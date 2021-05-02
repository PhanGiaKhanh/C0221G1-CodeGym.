package bai_tap_them.b3_manage_transport2.models;

public class XeMay extends PhuongTien {
    private double congSuat;

    public XeMay() {
    }

    public XeMay(String bienKiemSoat, String tenHangSX, int namSX, String chuSoHuu, double congSuat) {
        super(bienKiemSoat, tenHangSX, namSX, chuSoHuu);
        this.congSuat = congSuat;
    }

    public XeMay(String[] list){
        super(list);
        this.congSuat = Double.parseDouble(list[4]);
    }
    @Override
    public String toString() {
        return bienKiemSoat +
                "," + tenHangSX +
                "," + namSX +
                "," + chuSoHuu +
                "," + congSuat;
    }

    @Override
    public void showInfo() {
        System.out.println("\"XeMay{\" +\n" +
                "                \"bienKiemSoat='\" + bienKiemSoat + '\\'' +\n" +
                "                \", tenHangSX='\" + tenHangSX + '\\'' +\n" +
                "                \", namSX=\" + namSX +\n" +
                "                \", chuSoHuu='\" + chuSoHuu + '\\'' +\n" +
                "                \", congSuat=\" + congSuat +\n" +
                "                '}'");
    }
}
