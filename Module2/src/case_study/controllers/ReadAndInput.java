package case_study.controllers;

import java.util.Scanner;

public class ReadAndInput {
    static Scanner scanner = new Scanner(System.in);

    public static  void addNewServices() {
        int choose;
        do {
            System.out.println("1.\tAdd New Villa\n" +
                    "2.\tAdd New House\n" +
                    "3.\tAdd New Room\n" +
                    "4.\tBack to menu\n" +
                    "5.\tExit\n" +
                    "Choose: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1 : Input_InformationServices.villa();break;
                case 2 : Input_InformationServices.house();break;
                case 3 : Input_InformationServices.room();break;
                case 4 : MainController.displayMainMenu();break;
            }
        }while (choose != 5) ;
    }

    public static void showServices() {
        int choose;
        do {
            System.out.println("1.\tShow all Villa\n" +
                    "2.\tShow all House\n" +
                    "3.\tShow all Room\n" +
                    "4.\tShow All Name Villa Not Duplicate\n" +
                    "5.\tShow All Name House Not Duplicate\n" +
                    "6.\tShow All Name Room Not Duplicate\n" +
                    "7.\tBack to menu\n" +
                    "8.\tExit\n" +
                    "Choose: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1: Show_InformationServices.allVilla();break;
                case 2: Show_InformationServices.allHouse();break;
                case 3: Show_InformationServices.allRoom();break;
                case 4: Show_InformationServices.allNameVilla();break;
                case 5: Show_InformationServices.allNameHouse();break;
                case 6: Show_InformationServices.allNameRoom();break;
                case 7: MainController.displayMainMenu();break;
            }
        }while (choose != 8);
    }
}
