package bai_tap_them.b3_manage_transport3.controllers;

import bai_tap_them.b3_manage_transport3.commons.*;
import bai_tap_them.b3_manage_transport3.models.Vehicle;

import java.util.List;
import java.util.Scanner;

public class Function {
    private static Scanner scanner = new Scanner(System.in);

    public static void addVehicle() {
        byte choose;
        do {
            try {
                System.out.println("CHƯƠNG TRÌNH THÊM MỚI PHƯƠNG TIỆN GIAO THÔNG");
                System.out.println("1. Thêm xe tải\n" +
                        "2. Thêm ôtô \n" +
                        "3. Thêm  xe máy\n" +
                        "4. Quay lại menu chính\n" +
                        "5. Thoát");
                System.out.println("-------Chọn chức năng (1-5)-------");
                choose = Byte.parseByte(scanner.nextLine());
                switch (choose) {
                    case 1:
                        AddVehicle.truck();
                        break;
                    case 2:
                        AddVehicle.car();
                        break;
                    case 3:
                        AddVehicle.motorcycle();
                        break;
                    case 4:
                        return;
                    case 5:
                        System.err.println("ĐÃ THOÁT");
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Vui long nhập từ 1-5");
                        break;
                }
            } catch (Exception e) {
                System.err.println("Lỗi nhập:  " + e);
            }
        } while (true);
    }

    public static void showVehicle() {
        byte choose;
        do {
            try {
                System.out.println("CHƯƠNG TRÌNH HIỂN THỊ PHƯƠNG TIỆN GIAO THÔNG");
                System.out.println("1. Hiện thị xe tải.\n" +
                        "2. Hiện thị ôtô. \n" +
                        "3. Hiện  xe máy.\n" +
                        "4. Hiện  tất cả.\n" +
                        "5. Quay lại menu chính\n" +
                        "6. Thoát");
                System.out.println("-------Chọn chức năng (1-6)-------");
                choose = Byte.parseByte(scanner.nextLine());
                switch (choose) {
                    case 1:
                        ShowVehicle.truck();
                        break;
                    case 2:
                        ShowVehicle.car();
                        break;
                    case 3:
                        ShowVehicle.motorcycle();
                        break;
                    case 4:
                        ShowVehicle.getAll();
                        break;
                    case 5:
                        return;
                    case 6:
                        System.err.println("ĐÃ THOÁT");
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Vui long nhập từ 1-6");
                        break;
                }
            } catch (Exception e) {
                System.err.println("Lỗi nhập:  " + e);
            }
        } while (true);
    }

    public static void delVehicle() {
        byte choose;
        String input;
        List<Vehicle> vehicles = FileUtils.read("vehicle.csv");

        do {
            try {
                System.out.println("CHƯƠNG TRÌNH XÓA PHƯƠNG TIỆN GIAO THÔNG");
                System.out.println("Nhập biển kiểm soát: ");
                input = scanner.nextLine();
                for (int i = 0; i < vehicles.size(); i++) {
                    if (vehicles.get(i).getNumberPlate().equals(input)) {
                        vehicles.get(i).showInfo();
                        System.out.println("Bạn có muốn xóa không ?\n" +
                                "1. Yes\n" +
                                "2. No");
                        choose = Byte.parseByte(scanner.nextLine());
                        switch (choose) {
                            case 1:
                                vehicles.remove(i);
                                FileUtils.write("vehicle.csv",vehicles,false);
                                System.err.println("Xóa thành công");
                                return;
                            case 2:
                                return;
                        }
                    }
                }
                throw new NotFoundVehicelException("Biển kiểm soát không tồn tại.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
    }
}
