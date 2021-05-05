package case_study.controllers;

import bai12_java_collection_framework.thuc_hanh.set_find_binary.Tree;
import case_study.commons.Common;
import case_study.commons.FileUtils;
import case_study.models.House;
import case_study.models.Room;
import case_study.models.Service;
import case_study.models.Villa;

import java.util.*;

public class ShowServices {
    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu(){
        byte choose = 0;
        while (true){
            System.out.println("1.\tShowObject all Villa\n" +
                    "2.\tShowObject all House\n" +
                    "3.\tShowObject all Room\n" +
                    "4.\tShowObject All Name Villa Not Duplicate\n" +
                    "5.\tShowObject All Name House Not Duplicate\n" +
                    "6.\tShowObject All Name Room Not Duplicate\n" +
                    "7.\tBack to menu\n" +
                    "8.\tExit\n");
            System.out.println("-------Chọn chức năng (1-8)-------");
            try {
                choose = Byte.parseByte(scanner.nextLine());
            }catch (Exception e){
                System.err.println("Lỗi nhập:  "+ e);
            }
            switch (choose){
                case 1: showVilla();break;
                case 2: showHouse();break;
                case 3: showRoom();break;
                case 4: showNameVillaNotDup();break;
                case 5: showNameHouseNotDup();break;
                case 6: showNameRoomNotDup();break;
                case 7: return;
                case 8: System.err.println("ĐÃ THOÁT");System.exit(0);break;
                default: System.err.println("Vui long nhập từ 1-8");break;
            }
        }
    }

    private static void showNameRoomNotDup() {
        Set<String> treeSet = new TreeSet<>();
        List<Service> lists = FileUtils.read(Common.DATA_SERVICE);
        for (Service list : lists){
            if (list instanceof Room) {
                treeSet.add(list.getServiceName());
            }
        }
        System.out.println(treeSet);
    }
//    private static void showNameRoomNotDup() {
//        List<Service> listRoom = new ArrayList<>();
//        List<Service> lists = FileUtils.read(Common.DATA_SERVICE);
//        for (Service list : lists){
//            if (list instanceof Room) {
//                listRoom.add(list);
//            }
//        }
//        listRoom.sort(Comparator.comparing(Service :: getServiceName));
//        listRoom.forEach(e->e.showInfo());
//    }

    private static void showNameHouseNotDup() {
        Set<String> treeSet = new TreeSet<>();
        List<Service> lists = FileUtils.read(Common.DATA_SERVICE);
        for (Service list : lists){
            if (list instanceof House) {
                treeSet.add(list.getServiceName());
            }
        }
        System.out.println(treeSet);
    }

    private static void showNameVillaNotDup() {
        Set<String> treeSet = new TreeSet<>();
        List<Service> lists = FileUtils.read(Common.DATA_SERVICE);
        for (Service list : lists){
            if (list instanceof Villa) {
                treeSet.add(list.getServiceName());
            }
        }
        System.out.println(treeSet);
    }

    private static void showRoom() {
        List<Service> lists = FileUtils.read(Common.DATA_SERVICE);
        for (Service list : lists){
            if (list instanceof Room) {
                list.showInfo();
            }
        }
    }

    private static void showHouse() {
        List<Service> lists = FileUtils.read(Common.DATA_SERVICE);
        for (Service list : lists){
            if (list instanceof House) {
                list.showInfo();
            }
        }
    }

    private static void showVilla() {
        List<Service> lists = FileUtils.read(Common.DATA_SERVICE);
        for (Service list : lists){
            if (list instanceof Villa) {
                list.showInfo();
            }
        }
    }
}
