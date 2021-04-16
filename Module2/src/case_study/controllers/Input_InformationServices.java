package case_study.controllers;

import case_study.models.House;
import case_study.models.Room;
import case_study.models.Villa;

import java.util.Scanner;

public class Input_InformationServices {
    static Scanner scanner = new Scanner(System.in);
    public static  void service(){
        System.out.print("Input ID: ");
        String id = scanner.nextLine();
        System.out.print("Input service name: ");
        String serviceName = scanner.nextLine();
        System.out.print("Input Area: ");
        double area = Double.parseDouble(scanner.nextLine());
        System.out.print("Input Price: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.print("Input Capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());
        System.out.print("Input Rent Type");
        int rentType = Integer.parseInt(scanner.nextLine());
    }
    public static Villa villa(){
        System.out.println("Input information Villa");
        System.out.print("Input ID: ");
        String id = scanner.nextLine();
        System.out.print("Input service name: ");
        String serviceName = scanner.nextLine();
        System.out.print("Input Area: ");
        double area = Double.parseDouble(scanner.nextLine());
        System.out.print("Input Price: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.print("Input Capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());
        System.out.print("Input Rent Type");
        int rentType = Integer.parseInt(scanner.nextLine());
        System.out.print("Input Standard: ");
        String standard = scanner.nextLine();
        System.out.print("Input Convenient: ");
        String convenient = scanner.nextLine();
        System.out.print("Input Floors: ");
        int floors = Integer.parseInt(scanner.nextLine());
        System.out.print("Input Pool Area: ");
        double poolArea = Double.parseDouble(scanner.nextLine());
        return  new Villa(id, serviceName,area,price,capacity,rentType,standard,convenient,floors,poolArea);
    }
    public static Room room(){
        System.out.println("Input information Room");
        System.out.print("Input ID: ");
        String id = scanner.nextLine();
        System.out.print("Input service name: ");
        String serviceName = scanner.nextLine();
        System.out.print("Input Area: ");
        double area = Double.parseDouble(scanner.nextLine());
        System.out.print("Input Price: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.print("Input Capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());
        System.out.print("Input Rent Type");
        int rentType = Integer.parseInt(scanner.nextLine());
        System.out.print("Input free service: ");
        String freeService = scanner.nextLine();
        return  new Room(id, serviceName,area,price,capacity,rentType,freeService);
    }
    public static House house(){
        System.out.println("Input information House");
        System.out.print("Input ID: ");
        String id = scanner.nextLine();
        System.out.print("Input service name: ");
        String serviceName = scanner.nextLine();
        System.out.print("Input Area: ");
        double area = Double.parseDouble(scanner.nextLine());
        System.out.print("Input Price: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.print("Input Capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());
        System.out.print("Input Rent Type");
        int rentType = Integer.parseInt(scanner.nextLine());
        System.out.print("Input Standard: ");
        String standard = scanner.nextLine();
        System.out.print("Input convenient: ");
        String convenient = scanner.nextLine();
        System.out.print("Input Floors: ");
        int floors = Integer.parseInt(scanner.nextLine());
        return  new House( id, serviceName,area,price,capacity,rentType,standard,convenient,floors);
    }
}
