package library.Controllers;

import java.util.Scanner;

public class MainController {
    private static  Scanner scanner = new Scanner(System.in);

    public static void displayMenu(){
        String choose = "";
        while (true){
            System.out.println("1.\tAddObject New Services\n" +
                    "2.\tShowObject Services\n" +
                    "3.\tAddObject New Customer\n" +
                    "4.\tShowObject Information of Customer\n" +
                    "5.\tAddObject New Booking\n" +
                    "6.\tBack Menu" +
                    "7.\tExit");
            System.out.println("Chọn chức năng (1-7)");
            choose = scanner.nextLine();
            switch (choose){
                case "1": break;
                case "2": break;
                case "3": break;
                case "4": break;
                case "5": break;
                case "6": return;
                case "7": System.err.println("ĐÃ THOÁT");System.exit(0);break;
                default: System.err.println("Vui lòng nhập từ 1-7");break;
            }
            System.out.println();
        }
    }
}
