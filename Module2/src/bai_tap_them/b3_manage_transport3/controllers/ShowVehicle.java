package bai_tap_them.b3_manage_transport3.controllers;

import bai_tap_them.b3_manage_transport3.commons.FileUtils;
import bai_tap_them.b3_manage_transport3.models.Car;
import bai_tap_them.b3_manage_transport3.models.Motorcycle;
import bai_tap_them.b3_manage_transport3.models.Truck;
import bai_tap_them.b3_manage_transport3.models.Vehicle;

import java.util.List;

public class ShowVehicle {
    public static void getAll(){
        List<Vehicle> list = FileUtils.read("vehicle.csv");
        int count = 0;

        System.out.println("Hiển thị phương tiện giao thông");
        for (Vehicle vehicle : list) {
            count++;
            System.out.print(count + ". ");
            vehicle.showInfo();
        }
        System.out.println();
    }

    public static void car(){
        List<Vehicle> list = FileUtils.read("vehicle.csv");
        int count = 0;

        System.out.println("Hiển thị phương tiện xe oto");
        for (Vehicle vehicle : list) {
            if (vehicle instanceof Car){
                count++;
                System.out.print(count + ". ");
                vehicle.showInfo();
            }
        }
        System.out.println();
    }
    public static void truck(){
        List<Vehicle> list = FileUtils.read("vehicle.csv");
        int count = 0;

        System.out.println("Hiển thị phương tiện xe tải");
        for (Vehicle vehicle : list) {

            if (vehicle instanceof Truck){
                count++;
                System.out.print(count + ". ");
                vehicle.showInfo();
            }
        }
        System.out.println();
    }
    public static void motorcycle(){
        List<Vehicle> list = FileUtils.read("vehicle.csv");
        int count = 0;

        System.out.println("Hiển thị phương tiện xe máy");
        for (Vehicle vehicle : list) {
            if (vehicle instanceof Motorcycle){
                count++;
                System.out.print(count + ". ");
                vehicle.showInfo();
            }
        }
        System.out.println();
    }
}
