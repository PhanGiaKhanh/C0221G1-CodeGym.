package bai_tap_them.b7_quanly_thi_sinh_dh.models;

public class ThiSinhKhoiA extends ThiSinh {
    private String toan;
    private String ly;
    private String hoa;

    public ThiSinhKhoiA() {
    }

    public ThiSinhKhoiA(String toan, String ly, String hoa) {
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
    }

    public ThiSinhKhoiA(String soBaoDanh, String hoten, String diaChi, String uuTien, String toan, String ly, String hoa) {
        super(soBaoDanh, hoten, diaChi, uuTien);
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
    }

    @Override
    public String toString() {
        return soBaoDanh +
                ",1," + hoten +
                "," + diaChi +
                "," + uuTien +
                "," + toan +
                "," + ly +
                "," + hoa;
    }

    @Override
    public void showInfo() {
        System.out.println("ThiSinhKhoiA{" +
                "soBaoDanh='" + soBaoDanh + '\'' +
                ", hoten='" + hoten + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", uuTien='" + uuTien + '\'' +
                ", toan='" + toan + '\'' +
                ", ly='" + ly + '\'' +
                ", hoa='" + hoa + '\'' +
                '}');
    }

    public String getToan() {
        return toan;
    }

    public void setToan(String toan) {
        this.toan = toan;
    }

    public String getLy() {
        return ly;
    }

    public void setLy(String ly) {
        this.ly = ly;
    }

    public String getHoa() {
        return hoa;
    }

    public void setHoa(String hoa) {
        this.hoa = hoa;
    }
}
