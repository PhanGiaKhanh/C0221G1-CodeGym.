package bai_tap_them.b3_manage_transport3.controllers;

import bai_tap_them.b3_manage_transport3.commons.ExceptionExist;
import bai_tap_them.b3_manage_transport3.commons.FileUtils;
import bai_tap_them.b3_manage_transport3.commons.VehicleValidate;
import bai_tap_them.b3_manage_transport3.models.Car;
import bai_tap_them.b3_manage_transport3.models.Motorcycle;
import bai_tap_them.b3_manage_transport3.models.Truck;
import bai_tap_them.b3_manage_transport3.models.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddVehicle {
    private static final String REGEX_CAR = "^[0-9]{2}[AB]-[0-9]{3}.[0-9]{2}$";
    private static final String REGEX_TRUCK = "^[0-9]{2}[C]-[0-9]{3}.[0-9]{2}$";
    private static final String REGEX_MOTORCYCLE = "^[0-9]{2}-[A-Z][0-9]-[0-9]{3}.[0-9]{2}$";
    private static final String REGEX_YEAR = "^[12][0-9]{3}$";
    private static final String REGEX_NAME = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơ" +
            "ƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềể" +
            "ỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừ" +
            "ỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+(\\s{1}[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠ" +
            "àáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂ" +
            "ưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪ" +
            "ễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+)*$";
    private static final String REGEX_NUMBER = "^[1-9]|([1-9][0-9]*)$";
    private static final String CAR = "car";
    private static final String TRUCK = "truck";
    private static final String MOTORCYCLE = "motorcycle";
    private static Scanner scanner = new Scanner(System.in);

    public static void car(){
        System.out.println("Nhập thông tin oto: ");
        String numberPlate = addNumberPlate(CAR, REGEX_CAR);
        String manufacturerName= addManufacturerName();
        String yearOfManufacturer= add("yearOfManufacturer",REGEX_YEAR);
        String owner= add("owner",REGEX_NAME);
        String numberOfSeat= add("numberOfSeat",REGEX_NUMBER);
        String typeCar = addTypeCar(numberPlate);

        Vehicle car = new Car(numberPlate,manufacturerName, Integer.parseInt(yearOfManufacturer), owner, Integer.parseInt(numberOfSeat), typeCar);
        List<Vehicle> list = new ArrayList<>();
        list.add(car);
        FileUtils.write("vehicle.csv",list,true);
    }
    public static void truck(){
        System.out.println("Nhập thông tin truck: ");
        String numberPlate = addNumberPlate(TRUCK, REGEX_TRUCK);
        String manufacturerName= addManufacturerName();
        int yearOfManufacturer= Integer.parseInt(add("yearOfManufacturer",REGEX_YEAR));
        String owner= add("owner",REGEX_NAME);
        double payLoad = Double.parseDouble(add("payLoad", REGEX_NUMBER));

        Vehicle truck = new Truck(numberPlate,manufacturerName,yearOfManufacturer,owner,payLoad);
        List<Vehicle> list = new ArrayList<>();
        list.add(truck);
        FileUtils.write("vehicle.csv",list,true);
    }
    public static void motorcycle(){
        System.out.println("Nhập thông tin motorcycle: ");
        String numberPlate = addNumberPlate(MOTORCYCLE, REGEX_MOTORCYCLE);
        String manufacturerName= addManufacturerName();
        int yearOfManufacturer= Integer.parseInt(add("yearOfManufacturer",REGEX_YEAR));
        String owner= add("owner",REGEX_NAME);
        int wattage = Integer.parseInt(add("wattage", REGEX_NUMBER));

        Vehicle motorcycle= new Motorcycle(numberPlate,manufacturerName,yearOfManufacturer,owner,wattage);
        List<Vehicle> list = new ArrayList<>();
        list.add(motorcycle);
        FileUtils.write("vehicle.csv",list,true);
    }

    public static String addNumberPlate(String vehicle, String regex) {
        String input = null;
        List<Vehicle> list;
        String[] strings;
        do {
            try {
                System.out.println("Nhập bển kiểm soát " + vehicle + ": " + regex);
                input = scanner.nextLine();
                VehicleValidate.checkFormat("biển kiểm soát", input, regex);
                list = FileUtils.read("vehicle.csv");
                if (list.equals(null)){
                    break;
                }
                for (Vehicle vehicle1 : list){
                    strings =vehicle1.toString().split(",");
                    if(strings[0].equals(input)){
                        throw new ExceptionExist("biển kiểm soát đã tồn tại yêu cầu nhập lại");
                    }
                }
                break;
            } catch (VehicleValidate | ExceptionExist v) {
                System.err.println(v.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
        return input;
    }

    public static String add(String property, String regex){
        String input = null;
        do {
            try{
                System.out.println("Nhập " + property + ": ");
                input = scanner.nextLine();
                VehicleValidate.checkFormat(property, input, regex);
                break;
            } catch (VehicleValidate v) {
                System.err.println(v.getMessage());
            }
        }while (true);
        return input;
    }

    public static String addTypeCar(String numberPlate) {
        return numberPlate.matches("A") ? "Du lịch" : "Xe Khách";
    }
    public static String addManufacturerName(){
        List<String> list;
        String result = null;
        String choose = null;
        do {
            try {
                list = FileUtils.readManufacturer("hangSanXuat.csv");
                System.out.println("Nhập hãng sản xuất: ");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println((i+1) + ". " + list.get(i));
                }
                System.out.println("Chọn nhà sản xuất : 1-7");
                choose = scanner.nextLine();
                if (choose.matches("^[1-7]$")){
                    break;
                }
                throw new Exception("Lỗi nhập ");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }while (true);
        result = list.get(Integer.parseInt(choose)-1).split(",")[1];
        return result;
    }
}
