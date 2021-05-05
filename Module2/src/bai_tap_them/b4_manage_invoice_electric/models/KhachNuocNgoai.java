package bai_tap_them.b4_manage_invoice_electric.models;

public class KhachNuocNgoai extends KhachHang {
    private String quocTich;

    public KhachNuocNgoai() {
    }

    public KhachNuocNgoai(String quocTich) {
        this.quocTich = quocTich;
    }

    public KhachNuocNgoai(String maKhachHang, String tenKhachHang, String quocTich) {
        super(maKhachHang, tenKhachHang);
        this.quocTich = quocTich;
    }

    @Override
    public String toString() {
        return maKhachHang +
                "," + tenKhachHang +
                "," + quocTich;
    }

    @Override
    public void showInfo() {
        System.out.println("KhachNuocNgoai{" +
                "maKhachHang='" + maKhachHang + '\'' +
                ", tenKhachHang='" + tenKhachHang + '\'' +
                ", quocTich='" + quocTich + '\'' +
                '}');
    }
}
