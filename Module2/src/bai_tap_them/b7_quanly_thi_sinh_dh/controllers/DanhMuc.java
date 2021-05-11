package bai_tap_them.b7_quanly_thi_sinh_dh.controllers;

import java.util.Scanner;

public class DanhMuc {
    private static Scanner scanner = new Scanner(System.in);

    public static void hienThi(){
        String choose = "";
        while (true){
            System.out.println("1.\t Nhập thông tin thí sinh\n" +
                    "2.\t Hiển thị thông tin thí sinh\n" +
                    "3.\t Tìm kiếm theo số báo danh\n" +
                    "4.\t Thoát");
            System.out.println("Chọn chức năng (1-4)");
            choose = scanner.nextLine();
            switch (choose){
                case "1": ThemThiSinh.danhMuc();break;
                case "2": break;
                case "3": break;
                case "4": System.err.println("ĐÃ THOÁT");System.exit(0);break;
                default: System.err.println("Vui lòng nhập từ 1-4");break;
            }
            System.out.println();
        }
    }
}
