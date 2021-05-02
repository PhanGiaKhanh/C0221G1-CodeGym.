package bai_tap_them.b3_manage_transport2.controllers;

import java.util.Scanner;

public class ChuongTrinhQuanLyPhuongTien {
    private static Scanner scanner = new Scanner(System.in);

    public static void chonChucNang() {
        byte choose;
        do {
            try {
                System.out.println("CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG");
                System.out.println("1. Thêm mới phương tiện.\n" +
                        "2. Hiện thị phương tiện\n" +
                        "3. Xóa phương tiện\n" +
                        "4. Thoát");
                System.out.println("-------Chọn chức năng (1-4)-------");
                choose = Byte.parseByte(scanner.nextLine());
                switch (choose){
                    case 1: ChucNang.themMoiPhuongTien();break;
                    case 2: ChucNang.hienThiPhuongTien();break;
                    case 3: ChucNang.xoaPhuongTien();break;
                    case 4: System.exit(0);break;
                    default: System.err.println("----------Yêu cầu nhập 1-4----------");break;
                }
                if (String.valueOf(choose).matches("^\\D$")){
                    throw new Exception("Lỗi nhập");
                }
            }catch (Exception e){
                System.err.println("Lỗi nhập:  "+ e);
            }
        }while (true);
    }
}
