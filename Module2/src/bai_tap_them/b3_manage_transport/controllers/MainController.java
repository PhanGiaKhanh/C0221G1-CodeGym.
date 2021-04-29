package bai_tap_them.b3_manage_transport.controllers;

import java.util.List;
import java.util.Scanner;

public class MainController {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean isExit;

    public static void main(String[] args) {
        MainController.menuManageVehicle();
    }
    public static void menuManageVehicle(){
        byte choose;
        do {
            System.out.println("1. Thêm mới phương tiện.\n" +
                    "2. Hiện thị phương tiện\n" +
                    "3. Xóa phương tiện\n" +
                    "4. Thoát");
            System.out.println("Nhập lựa chọn (1~4): ");
            choose = Byte.parseByte(scanner.nextLine());
            switch (choose){
                case 1: VehicleController.addVehicle();break;
                case 2: VehicleController.showVehicle();break;
                case 3: VehicleController.deleteVehicle();break;
                case 4: isExit = true;break;
                default: System.err.println("________vui lòng chọn 1-4__________");break;
            }
            if (isExit){
                break;
            }
        }while (true);
    }
}
