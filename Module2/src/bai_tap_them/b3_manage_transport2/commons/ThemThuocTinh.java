package bai_tap_them.b3_manage_transport2.commons;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class ThemThuocTinh {
    public static final String DINHDANG_OTO = "^[0-9]{2}[AB]-[0-9]{3}.[0-9]{2}$";
    public static final String DINHDANG_XETAI = "^[0-9]{2}[C]-[0-9]{3}.[0-9]{2}$";
    public static final String DINHDANG_XEMAY = "^[0-9]{2}-[A-Z][0-9]-[0-9]{3}.[0-9]{2}$";
    public static final String OTO = "oto";
    public static final String XETAI = "xeTai";
    public static final String XEMAY = "xeMay";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Double s= ThemThuocTinh.trongTai();
        System.err.println(s);
    }

    public static String bienKiemSoat(String dinhDangXe) {
        String input;
        boolean isNotFound;
        do {
            try{
                System.out.println("Nhập biển kiểm soát : " + dinhDangXe);
                input = scanner.nextLine();
                if (input.matches(dinhDangXe)){
                    isNotFound = true;
                    for(String str : TapTin.doc()){
                        String[] tam = str.split(",");
                        if (tam[0].equals(input)){
                            isNotFound = false;
                        }
                    }
                    if(isNotFound){
                        break;
                    }else {
                        throw new Exception(input + "  Đã tồn tại");
                    }
                }
                throw new Exception("Lỗi nhập sai định dạng" + dinhDangXe);
            }catch (Exception e) {
                System.err.println(e);;
            }
        }while (true);
        return input;
    }

    public static String bienKiemSoatOto() {
        String input;
        boolean isNotFound = true;
        do {
            try{
                System.out.println("Nhập biển kiểm soát oto: " + DINHDANG_OTO);
                input = scanner.nextLine();
                if (input.matches(DINHDANG_OTO)){
                    for(String str : TapTin.doc()){
                        String[] tam = str.split(",");
                        if (tam[0].equals(input)){
                            isNotFound = false;
                        }
                    }
                    if(isNotFound){
                        break;
                    }else {
                        throw new Exception("Đã tồn tại");
                    }
                }
                throw new Exception("Lỗi nhập sai định dạng");
            }catch (Exception e) {
                e.printStackTrace();
            }
        }while (true);
        return input;
    }

    public static String tenHangSX() {
        String regex = "^[A-Z][a-z]*$";
        String input;
        do {
            try{
                System.out.println("Nhập tên hãng sản xuất: " + regex);
                input = scanner.nextLine();
                if (input.matches(regex)){
                    break;
                }
                throw new Exception("Lỗi nhập sai định dạng");
            }catch (Exception e) {
                System.err.println(e);;
            }
        }while (true);
        return input;
    }
    public static int namSX() {
        String regex = "^[0-2][0-9]{3}$";
        String input;
        do {
            try{
                System.out.println("Nhập năm sản xuất: " + regex);
                input = scanner.nextLine();
                if (input.matches(regex)){
                    break;
                }
                throw new Exception("Lỗi nhập sai định dạng");
            }catch (Exception e) {
                System.err.println(e);;
            }
        }while (true);
        return Integer.parseInt(input);
    }
    public static String chuSoHuu() {
        String regex = "([A-Z][a-z]*)+(\\s[A-Z][a-z]*)+";
        String input;
        do {
            try{
                System.out.println("Nhập chủ sở hữu: " + regex);
                input = scanner.nextLine();
                if (input.matches(regex)){
                    break;
                }
                throw new Exception("Lỗi nhập sai định dạng");
            }catch (Exception e) {
                System.err.println(e);;
            }
        }while (true);
        return input;
    }
    public static Double trongTai(){
        String regex = "^[1-9][0-9]*+(\\.[0-9]{1,2})?$";
        String input;
        do {
            try{
                System.out.println("Nhập trọng tải: " + regex);
                input = scanner.nextLine();
                if (input.matches(regex)){
                    break;
                }
                throw new Exception("Lỗi nhập sai định dạng");
            }catch (Exception e) {
                System.err.println(e);;
            }
        }while (true);
        return Double.parseDouble(input);
    }
    public static int soChoNgoi(){
        String regex = "^[0-9]{1,2}$";
        String input;
        do {
            try{
                System.out.println("Nhập số chỗ ngồi: " + regex);
                input = scanner.nextLine();
                if (input.matches(regex)){
                    int soChoNgoi = Integer.parseInt(input);
                    boolean kiemTra = soChoNgoi > 0 && soChoNgoi < 20;
                    if (kiemTra){
                        break;
                    }
                    throw new Exception("số ngồi từ 1 - 20");
                }
                throw new Exception("Lỗi nhập sai định dạng");
            }catch (Exception e) {
                System.err.println(e);;
            }
        }while (true);
        return Integer.parseInt(input);
    }
    public static double congSuat(){
        String regex = "^[0-9]*+\\.[0-9]{1,2}$";
        String input;
        do {
            try{
                System.out.println("Nhập công suất: " + regex);
                input = scanner.nextLine();
                if (input.matches(regex)){
                        break;
                }
                throw new Exception("Lỗi nhập sai định dạng");
            }catch (Exception e) {
                System.err.println(e);;
            }
        }while (true);
        return Integer.parseInt(input);
    }
}
