package bai_tap_them.b3_manage_transport.controllers;

import bai_tap_them.b3_manage_transport.commons.CreateVehicle;
import bai_tap_them.b3_manage_transport.commons.DisplayVehicle;
import bai_tap_them.b3_manage_transport.commons.FileUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleController {
    private static Scanner scanner = new Scanner(System.in);

    public static void addVehicle() {
        byte choose;
        do {
            try {
                System.out.println("1. Thêm xe tải\n" +
                        "2. Thêm ôtô \n" +
                        "3. Thêm  xe máy\n" +
                        "4. Thoát");
                System.out.println("Chọn 1-4");
                choose = Byte.parseByte(scanner.nextLine());
                switch (choose) {
                    case 1:
                        FileUtils.writeFile(CreateVehicle.createTruck().toString());
                        break;
                    case 2:
                        FileUtils.writeFile(CreateVehicle.createCar().toString());
                        break;
                    case 3:
                        FileUtils.writeFile(CreateVehicle.createMotobike().toString());
                        break;
                    case 4:
                        return;
                    default:
                        System.err.println("-------Vui lòng nhập từ 1 - 4-------");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
    }

    public static void showVehicle() {
        byte choose;
        do {
            try {
                System.out.println("1. Hiện thị xe tải.\n" +
                        "2. Hiện thị ôtô. \n" +
                        "3. Hiện  xe máy.\n" +
                        "4. Thoát");
                System.out.println("Nhập lựa chọn: 1~4");
                choose = Byte.parseByte(scanner.nextLine());
                switch (choose) {
                    case 1:
                        DisplayVehicle.showTruck();
                        break;
                    case 2:
                        DisplayVehicle.showCar();
                        break;
                    case 3:
                        DisplayVehicle.showMotobike();
                        break;
                    case 4:
                        return;
                    default:
                        System.err.println("-------Vui long nhập từ 1-4-------");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
    }

    public static void deleteVehicle() {
        String bienKiemSoat;
        List<String> list;
        System.out.println("Nhập biển kiểm soát cần xóa: ");
        boolean check = false;
        try {
            bienKiemSoat = scanner.nextLine();
            list = FileUtils.readFile();
            FileUtils.deleteFile();
            for (String str : list) {
                if (str.split(",")[0].equals(bienKiemSoat)) {
                    check = true;
                    System.out.println(str);
                    System.out.println("Bạn có muốn xóa không?");
                    System.out.println("1. Yes\n" +
                            "2. No");
                    System.out.println("Chọn : ");
                    switch (Integer.parseInt(scanner.nextLine())){
                        case 1: System.out.println("Xóa thành công");continue;
                        case 2: break;
                        default: System.out.println("-------Vui lòng nhập 1-2-------");
                    }
                }
                FileUtils.writeFile(str);
            }
            if (!check) {
                throw new Exception("Không tồn tại");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
