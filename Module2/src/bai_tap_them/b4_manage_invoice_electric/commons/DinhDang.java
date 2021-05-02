package bai_tap_them.b4_manage_invoice_electric.commons;

import java.util.Scanner;

public class DinhDang {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        DinhDang.maKhachHang();
        System.err.println("Thành công");
    }
    public static String maKhachHang() {
        String regex = "^(([K][H][V][N])|([K][H][N][N]))-[0-9]{5}$";
        String nhap;
        do {
            try {
                System.out.println("Nhập mã khách hàng : KHVN(KHNN)-XXXXX (X : 0÷9)");
                nhap = scanner.nextLine();
                if (nhap.matches(regex)) {
                    break;
                }
                throw new Exception("Nhập sai định dạng");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }while (true);
        return nhap;
    }
}

