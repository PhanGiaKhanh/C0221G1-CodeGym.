package case_study.controllers;

import java.util.Scanner;

public class AddNewBooking {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMenu(){
        byte choose = 0;
        while (true){
            System.out.println("Add new booking\n" +
                    "1.\tBooking Villa\n" +
                    "2.\tBooking House\n" +
                    "3.\tBooking Room\n" +
                    "4.\tBack Menu\n" +
                    "5.\tExit\n");
            System.out.println("Chọn chức năng (1-7)");
            try {
                choose = Byte.parseByte(scanner.nextLine());
            }catch (NumberFormatException e){
                System.err.println("Lỗi nhập:  "+ e);
            }
            switch (choose){
                case 1: break;
                case 2: break;
                case 3: break;
                case 4: break;
                case 5: break;
                case 6: return;
                case 7: System.err.println("ĐÃ THOÁT");System.exit(0);break;
                default: System.err.println("Vui lòng nhập từ 1-7");break;
            }
            System.out.println();
        }
    }
}
