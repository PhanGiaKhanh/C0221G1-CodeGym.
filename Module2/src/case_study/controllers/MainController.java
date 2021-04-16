package case_study.controllers;

import java.util.Scanner;

public class MainController {
    static Scanner scanner = new Scanner(System.in);
    public static void displayMainMenu(){
        int choose = 0;
        do{
            System.out.print("1.\t Add New Services\n" +
                    "2.\tShow Services\n" +
                    "3.\tAdd New Customer\n" +
                    "4.\tShow Information of Customer\n" +
                    "5.\tAdd New Booking\n" +
                    "6.\tShow Information of Employee\n" +
                    "7.\tExit\n" +
                    "Choose: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1 : ReadAndInput.addNewServices(); break;
//                case 2 : showServices(); break;

            }
        }while (choose>=7);
    }

}
