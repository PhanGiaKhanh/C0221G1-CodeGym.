package bai_tap_them.b3_manage_transport3.controllers;

import bai_tap_them.b3_manage_transport2.controllers.ChucNang;

import java.util.Scanner;

public class MainControllers {
    private static Scanner scanner = new Scanner(System.in);

    public static void menuVehicle() {
        byte choose;
        do {
            try {
                System.out.println("CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG (VERSION 3)");
                System.out.println("1. Thêm mới phương tiện.\n" +
                        "2. Hiện thị phương tiện\n" +
                        "3. Xóa phương tiện\n" +
                        "4. Thoát");
                System.out.println("-------Chọn chức năng (1-4)-------");
                choose = Byte.parseByte(scanner.nextLine());
                switch (choose){
                    case 1: Function.addVehicle();break;
                    case 2: Function.showVehicle();break;
                    case 3: Function.delVehicle();break;
                    case 4: System.err.println("ĐÃ THOÁT");System.exit(0);break;
                    default: System.err.println("Vui long nhập từ 1-4");break;
                }
            }catch (Exception e){
                System.err.println("Lỗi nhập:  "+ e);
            }
        }while (true);
    }
}
