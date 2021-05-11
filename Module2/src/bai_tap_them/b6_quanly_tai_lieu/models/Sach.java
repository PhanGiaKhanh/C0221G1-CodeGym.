package bai_tap_them.b6_quanly_tai_lieu.models;

public class Sach extends TaiLieu {
    private String tenTacGia;
    private String soTrang;

    public Sach() {
    }

    public Sach(String tenTacGia, String soTrang) {
        this.tenTacGia = tenTacGia;
        this.soTrang = soTrang;
    }

    public Sach(String maTaiLieu, String tenNhaSX, String soBanPhatHanh, String tenTacGia, String soTrang) {
        super(maTaiLieu, tenNhaSX, soBanPhatHanh);
        this.tenTacGia = tenTacGia;
        this.soTrang = soTrang;
    }

    @Override
    public String toString() {
        return maTaiLieu +
                ",1," + tenNhaSX +
                "," + soBanPhatHanh +
                "," + tenTacGia +
                "," + soTrang;
    }

    @Override
    public void showInfo() {
        System.out.printf("%-5s %-20s %-5s %-15s %-15s \n",maTaiLieu,tenNhaSX,soBanPhatHanh,tenTacGia,soTrang);

    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(String soTrang) {
        this.soTrang = soTrang;
    }
}
