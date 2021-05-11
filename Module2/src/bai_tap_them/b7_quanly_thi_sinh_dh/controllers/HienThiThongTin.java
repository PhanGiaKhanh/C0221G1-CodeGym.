package bai_tap_them.b7_quanly_thi_sinh_dh.controllers;

import java.util.Scanner;

public class HienThiThongTin {
    private static Scanner scanner = new Scanner(System.in);

    public static void danhMuc(){
        String choose = "";
        while (true){
            System.out.println("1.\t Hiển thị thông tin thí khối A\n" +
                    "2.\t Hiển thị thông tin thí khối B\n" +
                    "3.\t Hiển thị thông tin thí khối C\n" +
                    "4.\t Hiển thị thông tin theo tên\n" +
                    "5.\t Trở lại\n" +
                    "6.\t Thoát");
            System.out.println("Chọn chức năng (1-4)");
            choose = scanner.nextLine();
            switch (choose){
                case "1": hienThiKhoiA();break;
                case "2": hienThiKhoiB();break;
                case "3": hienThiKhoiC();break;
                case "4": hienThiTheoTen();break;
                case "5": return;
                case "6": System.err.println("ĐÃ THOÁT");System.exit(0);break;
                default: System.err.println("Vui lòng nhập từ 1-4");break;
            }
            System.out.println();
        }
    }

    private static void hienThiTheoTen() {
    }

    private static void hienThiKhoiC() {
    }

    private static void hienThiKhoiB() {
    }

    private static void hienThiKhoiA() {
    }
}
