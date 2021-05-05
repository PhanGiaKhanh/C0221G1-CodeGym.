package bai_tap_them.b4_manage_invoice_electric.controllers;

import bai_tap_them.b3_manage_transport3.commons.VehicleValidate;

import java.util.Scanner;

public class ThemMoi {
    private static Scanner scanner = new Scanner(System.in);
    public static void khachHangVN(){
        String maKhachHang ;
        String hoTen= add("họ tên", Chung.NAME);
        int dinhMucTieuThu = Integer.parseInt(add("định mức tiêu thụ", Chung.NUMBER));

    }
    public static void khachHangNN(){}

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
}
