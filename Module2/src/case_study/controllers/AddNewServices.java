package case_study.controllers;

import bai_tap_them.b3_manage_transport3.commons.VehicleValidate;
import case_study.commons.Common;
import case_study.commons.FileUtils;
import case_study.commons.ValidateService;
import case_study.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddNewServices {
    private static Scanner scanner = new Scanner(System.in);
    public static void showMenu(){
        byte choose;
        do {
            try {
                System.out.println("Bao gồm trình đơn:\n" +
                        "1.\tAddObject New Villa\n" +
                        "2.\tAddObject New House\n" +
                        "3.\tAddObject New Room\n" +
                        "4.\tBack to menu\n" +
                        "5.\tExit\n");
                System.out.println("-------Chọn chức năng (1-4)-------");
                choose = Byte.parseByte(scanner.nextLine());
                switch (choose){
                    case 1: addVilla();break;
                    case 2: addHouse();break;
                    case 3: addRoom();break;
                    case 4: return;
                    case 5: System.err.println("ĐÃ THOÁT");System.exit(0);break;
                    default: System.err.println("Vui long nhập từ 1-4");break;
                }
            }catch (Exception e){
                System.err.println("Lỗi nhập:  "+ e);
            }
        }while (true);
    }

    public static void main(String[] args) {

    }
    public static void addVilla(){
        System.out.println("Nhập thông tin villa");
        String ma = "SVVL";
        List<Service> lists = FileUtils.read(Common.DATA_SERVICE);
        List<Service> villas = new ArrayList<>();
        for (Service list : lists){
            if (list instanceof Villa){
                villas.add(list);
            }
        }
        String id = "";
        while (true){
            id = ma + (villas.size() +1);
            if (id.matches(Common.Id_ROOM)){
                break;
            }
            ma = ma + "0";
            id = "";
        }
        String serviceName = add("service name", Common.NAME);
        double area = Double.parseDouble(add("area", Common.AREA));
        int price = Integer.parseInt(add("price", Common.PRICE));
        int capacity = Integer.parseInt(add("capacity", Common.CAPACITY));
        String rentType = add("rent type", Common.TYPE_RENT);
        String standard = add("standard", Common.STANDARD); //tiêu chuẩn
        String convenient = add("convenient", Common.NAME); // tiện  nghi
        int floors = Integer.parseInt(add("floors", Common.FLOORS));
        double poolArea = Double.parseDouble(add("pool area", Common.AREA ));

        Service villa = new Villa(id,serviceName,area,price,capacity,rentType,standard,convenient,floors,poolArea);
        List<Service> list1 = new ArrayList<>();
        list1.add(villa);
        FileUtils.write(Common.DATA_SERVICE,list1,true);
    }

    public static void addHouse(){
        System.out.println("Nhập thông tin house");
        String ma = "SVHO";
        List<Service> lists = FileUtils.read(Common.DATA_SERVICE);
        List<Service> houses = new ArrayList<>();
        for (Service list : lists){
            if (list instanceof House){
                houses.add(list);
            }
        }
        String id = "";
        while (true){
            id = ma + (houses.size() +1);
            if (id.matches(Common.Id_ROOM)){
                break;
            }
            ma = ma + "0";
            id = "";
        }
        String serviceName = add("service name", Common.NAME);
        double area = Double.parseDouble(add("area", Common.AREA));
        int price = Integer.parseInt(add("price", Common.PRICE));
        int capacity = Integer.parseInt(add("capacity", Common.CAPACITY));
        String rentType = add("rent type", Common.TYPE_RENT);
        String standard = add("standard", Common.STANDARD); //tiêu chuẩn
        String convenient = add("convenient", Common.NAME); // tiện  nghi
        int floors = Integer.parseInt(add("floors", Common.FLOORS));

        Service house = new House(id,serviceName,area,price,capacity,rentType,standard,convenient,floors);
        List<Service> list1 = new ArrayList<>();
        list1.add(house);
        FileUtils.write(Common.DATA_SERVICE,list1,true);
    }


    public static  void addRoom(){
        System.out.println("Nhập thông tin room");
        String ma = "SVRO-";
        List<Service> lists = FileUtils.read(Common.DATA_SERVICE);
        List<Service> rooms = new ArrayList<>();
        for (Service list : lists){
            if (list instanceof Room){
                rooms.add(list);
            }
        }
        String id = "";
        while (true){
            id = ma + (rooms.size() +1);
            if (id.matches(Common.Id_ROOM)){
                break;
            }
            ma = ma + "0";
            id = "";
        }
        String serviceName = add("service name", Common.NAME);
        double area = Double.parseDouble(add("area", Common.AREA));
        int price = Integer.parseInt(add("rental costs", Common.PRICE));
        int capacity = Integer.parseInt(add("capacity", Common.CAPACITY));
        String rentType = add("rent type", Common.TYPE_RENT);
        String extraServiceName = add("extra service name",Common.NAME);
        String unit = add("unit", Common.NAME);
        double priceMoney = Double.parseDouble(add("price", Common.NUMBER));
        ExtraService extraService = new ExtraService(extraServiceName,unit,priceMoney);
        Service room = new Room(id,serviceName,area,price,capacity,rentType,extraService);
        List<Service> list1 = new ArrayList<>();
        list1.add(room);
        FileUtils.write(Common.DATA_SERVICE,list1,true);
    }
    public static String add(String property, String regex){
        String input = null;
        do {
            try{
                System.out.println("Nhập " + property + ": " +regex);
                input = scanner.nextLine();
                ValidateService.checkFormat(property, input, regex);
                break;
            } catch (VehicleValidate v) {
                System.err.println(v.getMessage());
            }
        }while (true);
        return input;
    }
}
