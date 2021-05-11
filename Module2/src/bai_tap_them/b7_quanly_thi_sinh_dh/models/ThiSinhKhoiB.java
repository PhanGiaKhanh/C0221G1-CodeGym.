package bai_tap_them.b7_quanly_thi_sinh_dh.models;

public class ThiSinhKhoiB extends ThiSinh {
    private String toan;
    private String hoa;
    private String sinh;

    public ThiSinhKhoiB() {
    }

    public ThiSinhKhoiB(String toan, String hoa, String sinh) {
        this.toan = toan;
        this.hoa = hoa;
        this.sinh = sinh;
    }

    public ThiSinhKhoiB(String soBaoDanh, String hoten, String diaChi, String uuTien, String toan, String hoa, String sinh) {
        super(soBaoDanh, hoten, diaChi, uuTien);
        this.toan = toan;
        this.hoa = hoa;
        this.sinh = sinh;
    }

    @Override
    public String toString() {
        return soBaoDanh +
                ",2," + hoten +
                "," + diaChi +
                "," + uuTien +
                "," + toan +
                "," + hoa +
                "," + sinh;
    }

    @Override
    public void showInfo() {
        System.out.println("ThiSinhKhoiB{" +
                "soBaoDanh='" + soBaoDanh + '\'' +
                ", hoten='" + hoten + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", uuTien='" + uuTien + '\'' +
                ", toan='" + toan + '\'' +
                ", hoa='" + hoa + '\'' +
                ", sinh='" + sinh + '\'' +
                '}');
    }

    public String getToan() {
        return toan;
    }

    public void setToan(String toan) {
        this.toan = toan;
    }

    public String getHoa() {
        return hoa;
    }

    public void setHoa(String hoa) {
        this.hoa = hoa;
    }

    public String getSinh() {
        return sinh;
    }

    public void setSinh(String sinh) {
        this.sinh = sinh;
    }
}
