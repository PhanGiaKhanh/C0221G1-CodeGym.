package bai_tap_them.b6_quanly_tai_lieu.models;

public class Bao extends TaiLieu {
    private String ngayPhatHanh;

    public Bao() {
    }

    public Bao(String ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public Bao(String maTaiLieu, String tenNhaSX, String soBanPhatHanh, String ngayPhatHanh) {
        super(maTaiLieu, tenNhaSX, soBanPhatHanh);
        this.ngayPhatHanh = ngayPhatHanh;
    }

    @Override
    public String toString() {
        return maTaiLieu +
                ",3," + tenNhaSX +
                "," + soBanPhatHanh +
                "," + ngayPhatHanh;
    }

    @Override
    public void showInfo() {
        System.out.printf("%-5s %-20s %-5s %-15s\n",maTaiLieu,tenNhaSX,soBanPhatHanh,ngayPhatHanh);
    }

    public String getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(String ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }
}
