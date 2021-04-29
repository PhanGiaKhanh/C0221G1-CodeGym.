package bai_tap_them.b3_manage_transport.commons;

import java.util.Scanner;

public class Validate {
    private static Scanner scanner = new Scanner(System.in);

    public static String validateBienKiemSoat(String regex) {
        String bienKiemSoat;
        do {
            System.out.println("Nhập biển kiểm soát: XXC|Y-XXX.XXX  ");
            bienKiemSoat = scanner.nextLine();
            if (bienKiemSoat.matches(regex)) {
                break;
            }
            System.err.println("_____Nhập sai định dạng_____");
        } while (true);
        return bienKiemSoat;
    }

    public static String validateHangSanXuat() {
        String hangSanXuat;
        String regex = "^[A-Z][a-z]+$";
        do {
            System.out.println("Nhập hãng sản xuất: (vd: Huyndai)  ");
            hangSanXuat = scanner.nextLine();
            if (hangSanXuat.matches(regex)) {
                break;
            }
            System.err.println("_____Nhập sai định dạng_____");
        } while (true);
        return hangSanXuat;
    }

    public static int validateNamSanXuat() {
        String namSanXuat;
        String regex = "^[12][0-9]{3}$";
        do {
            System.out.println("Nhập năm sản xuất: (vd: 2020)  ");
            namSanXuat = scanner.nextLine();
            if (namSanXuat.matches(regex)) {
                break;
            }
            System.err.println("_____Nhập sai định dạng_____");
        } while (true);
        return Integer.parseInt(namSanXuat);
    }

    public static String validateChuSoHuu() {
        String chuSoHuu;
        String regex = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơ" +
                "ƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềể" +
                "ỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừ" +
                "ỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+(\\s{1}[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠ" +
                "àáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂ" +
                "ưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪ" +
                "ễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+)*$";
        do {
            System.out.println("Nhập chủ sở hữu: (vd: Nguyễn Văn)  ");
            chuSoHuu = scanner.nextLine();
            if (chuSoHuu.matches(regex)) {
                break;
            }
            System.err.println("_____Nhập sai định dạng_____");
        } while (true);
        return chuSoHuu;
    }
    public static int validateSoChoNgoi() {
        String soChoNgoi;
        String regex = "^[1-9][0-9]*$";
        do {
            try{
                System.out.println("Nhập số chỗ ngồi: (vd: 20)  ");
                soChoNgoi = scanner.nextLine();
                if (soChoNgoi.matches(regex)) {
                    break;
                }
                throw new Exception("Nhập sai định dạng ");
            }catch (Exception e){
                e.printStackTrace();
            }
        } while (true);
        return Integer.parseInt(soChoNgoi);
    }

    public static String validateTrongTai() {
        String trongTai;
        String regex = "^[0-9]+$";
        do {
            try{
                System.out.println("Nhập số trọng tải: (vd: 20)  ");
                trongTai = scanner.nextLine();
                if (trongTai.matches(regex)) {
                    break;
                }
                throw new Exception("Nhập sai định dạng ");
            }catch (Exception e){
                e.printStackTrace();
            }
        } while (true);
        return trongTai;
    }
    public static Double validateCongSuat() {
        String congSuat;
        String regex = "^[0-9]+$";
        do {
            try{
                System.out.println("Nhập số công suất: (vd: 20)  ");
                congSuat = scanner.nextLine();
                if (congSuat.matches(regex)) {
                    break;
                }
                throw new Exception("Nhập sai định dạng ");
            }catch (Exception e){
                e.printStackTrace();
            }
        } while (true);
        return Double.parseDouble(congSuat);
    }
}
