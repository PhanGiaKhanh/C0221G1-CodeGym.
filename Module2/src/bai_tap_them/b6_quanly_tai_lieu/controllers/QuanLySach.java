package bai_tap_them.b6_quanly_tai_lieu.controllers;

import java.util.Scanner;

public class QuanLySach {
    private static Scanner scanner = new Scanner(System.in);

    public static void hienThi(){
        String choose = "";
        while (true){
            System.out.println("1.\t Nhập thông tin về các tài liệu \n" +
                    "2.\t Hiển thị thông tin về các tài liệu \n" +
                    "3.\t Tìm kiếm tài liệu theo loại\n" +
                    "4.\t Thoát");
            System.out.println("Chọn chức năng (1-4)");
            choose = scanner.nextLine();
            switch (choose){
                case "1": NhapThongTin.danhMuc();break;
                case "2": HienThiThongTin.danhMuc();break;
                case "3": timKiemTheoLoai();break;
                case "4": System.err.println("ĐÃ THOÁT");System.exit(0);break;
                default: System.err.println("Vui lòng nhập từ 1-4");break;
            }
            System.out.println();
        }
    }

    private static void timKiemTheoLoai() {
        System.out.println("Nhập tên tên");
    }
}
