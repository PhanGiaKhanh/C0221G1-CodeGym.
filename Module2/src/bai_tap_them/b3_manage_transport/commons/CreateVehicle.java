package bai_tap_them.b3_manage_transport.commons;

import bai_tap_them.b3_manage_transport.models.Car;
import bai_tap_them.b3_manage_transport.models.Motobike;
import bai_tap_them.b3_manage_transport.models.Truck;
import bai_tap_them.b3_manage_transport.models.Vehicle;

import java.util.Scanner;

public class CreateVehicle {
    private static Scanner scanner = new Scanner(System.in);
    private static final String REGEX_CAR = "^[0-9]{2}[AB]-[0-9]{3}.[0-9]{2}$";
    private static final String REGEX_MOTOBIKE = "^[0-9]{2}-[A-Z][0-9A-Z]-[0-9]{3}.[0-9]{2}$";
    private static final String REGEX_TRUCK = "^[0-9]{2}[A-Z]-[0-9]{2,3}.[0-9]{2,3}$";
    private static final String CAR = "car";
    private static final String MOTOBIKE = "motobike";
    private static final String TRUCK = "truck";

    public static Vehicle createCar(){
        System.out.println("Nhập thông tin Oto ");
        String bienKiemSoat = Validate.validateBienKiemSoat(REGEX_CAR);
        String hangSanXuat = Validate.validateHangSanXuat();
        int namSanXuat = Validate.validateNamSanXuat();
        String chuSoHuu = Validate.validateChuSoHuu();
        int soChoNgoi = Validate.validateSoChoNgoi();
        String kieuXe ;
        String kieue ;

        kieuXe = (bienKiemSoat.contains("A")) ? "Xe du lịch" : "Xe khách";
        return new Car(bienKiemSoat,hangSanXuat,namSanXuat,chuSoHuu,soChoNgoi,kieuXe);
    }

    public static Vehicle createMotobike(){
        System.out.println("Nhập thông tin Xe máy ");
        String bienKiemSoat = Validate.validateBienKiemSoat(REGEX_MOTOBIKE);
        String hangSanXuat = Validate.validateHangSanXuat();
        int namSanXuat = Validate.validateNamSanXuat();
        String chuSoHuu = Validate.validateChuSoHuu();
        String trongTai = Validate.validateTrongTai();

        return new Motobike(bienKiemSoat,hangSanXuat,namSanXuat,chuSoHuu,trongTai);
    }
    public static Vehicle createTruck(){
        System.out.println("Nhập thông tin Xe tải ");
        String bienKiemSoat = Validate.validateBienKiemSoat(REGEX_TRUCK);
        String hangSanXuat = Validate.validateHangSanXuat();
        int namSanXuat = Validate.validateNamSanXuat();
        String chuSoHuu = Validate.validateChuSoHuu();
        Double congSuat = Validate.validateCongSuat();

        return new Truck(bienKiemSoat,hangSanXuat,namSanXuat,chuSoHuu,congSuat);
    }

}
