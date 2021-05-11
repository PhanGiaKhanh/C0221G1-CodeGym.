package library.Controllers;

import java.util.Scanner;

public class MainController {

    public static void displayMenu(){
        String choose = "";
        while (true){
            System.out.println("1.\t \n" +
                    "2.\t \n" +
                    "3.\t \n" +
                    "4.\t \n" +
                    "5.\t \n" +
                    "6.\t Trở lại" +
                    "7.\t Thoát");
            System.out.println("Chọn chức năng (1-7)");
            choose = new Scanner(System.in).nextLine();
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
