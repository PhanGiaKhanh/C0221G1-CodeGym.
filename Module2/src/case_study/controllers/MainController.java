package case_study.controllers;


import java.util.Scanner;

public class MainController {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MainController.displayMainMenu();
    }
    public static void displayMainMenu(){
        byte choose;
        do {
            try {
                System.out.println("1.\tAdd New Services\n" +
                        "2.\tShow Services\n" +
                        "3.\tAdd New Customer\n" +
                        "4.\tShow Information of Customer\n" +
                        "5.\tAdd New Booking\n" +
                        "6.\tShow Information of Employee\n" +
                        "7.\tExit\n");
                System.out.println("-------Chọn chức năng (1-7)-------");
                choose = Byte.parseByte(scanner.nextLine());
                switch (choose){
                    case 1: AddNewServices.showMenu();break;
                    case 2: ShowServices.showMenu();break;
                    case 3: AddNewCustomer.addNew();break;
                    case 4: ShowInformationCustomer.show();break;
                    case 5: break;
                    case 6: break;
                    case 7: System.err.println("ĐÃ THOÁT");System.exit(0);break;
                    default: System.err.println("Vui long nhập từ 1-7");break;
                }
            }catch (Exception e){
                System.err.println("Lỗi nhập:  "+ e);
            }
        }while (true);
    }

}
