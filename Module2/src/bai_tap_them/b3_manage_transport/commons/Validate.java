package bai_tap_them.b3_manage_transport.commons;

import java.util.Scanner;

public class Validate {
    private static Scanner scanner = new Scanner(System.in);

    public static String validateBienKiemSoat(String regex) {
        String input;
        do {
            System.out.println("Nhập biển kiểm soát: XXC|Y-XXX.XXX  ");
            input = scanner.nextLine();
            if (input.matches(regex)) {
                break;
            }
            System.err.println("_____Nhập sai định dạng_____");
        } while (true);
        return input;
    }

    public static String validateHangSanXuat() {
        String input;
        String regex = "^[A-Z][a-z]+$";
        do {
            System.out.println("Nhập hãng sản xuất: (vd: Huyndai)  ");
            input = scanner.nextLine();
            if (input.matches(regex)) {
                break;
            }
            System.err.println("_____Nhập sai định dạng_____");
        } while (true);
        return input;
    }

    public static int validateNamSanXuat() {
        String input;
        String regex = "^[12][0-9]{3}$";
        do {
            System.out.println("Nhập năm sản xuất: (vd: 2020)  ");
            input = scanner.nextLine();
            if (input.matches(regex)) {
                break;
            }
            System.err.println("_____Nhập sai định dạng_____");
        } while (true);
        return Integer.parseInt(input);
    }

    public static String validateChuSoHuu() {
        String input;
        String regex = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơ" +
                "ƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềể" +
                "ỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừ" +
                "ỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+(\\s{1}[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠ" +
                "àáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂ" +
                "ưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪ" +
                "ễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+)*$";
        do {
            System.out.println("Nhập chủ sở hữu: (vd: Nguyễn Văn)  ");
            input = scanner.nextLine();
            if (input.matches(regex)) {
                break;
            }
            System.err.println("_____Nhập sai định dạng_____");
        } while (true);
        return input;
    }
    public static int validateSoChoNgoi() {
        String input;
        String regex = "^[1-9][0-9]*$";
        do {
            try{
                System.out.println("Nhập số chỗ ngồi: (vd: 20)  ");
                input = scanner.nextLine();
                if (input.matches(regex)) {
                    break;
                }
                throw new Exception("Nhập sai định dạng ");
            }catch (Exception e){
                e.printStackTrace();
            }
        } while (true);
        return Integer.parseInt(input);
    }

    public static String validateTrongTai() {
        String input;
        String regex = "^[0-9]+$";
        do {
            try{
                System.out.println("Nhập số trọng tải: (vd: 20)  ");
                input = scanner.nextLine();
                if (input.matches(regex)) {
                    break;
                }
                throw new Exception("Nhập sai định dạng ");
            }catch (Exception e){
                e.printStackTrace();
            }
        } while (true);
        return input;
    }
    public static Double validateCongSuat() {
        String input;
        String regex = "^[0-9]+$";
        do {
            try{
                System.out.println("Nhập số công suất: (vd: 20)  ");
                input = scanner.nextLine();
                if (input.matches(regex)) {
                    break;
                }
                throw new Exception("Nhập sai định dạng ");
            }catch (Exception e){
                e.printStackTrace();
            }
        } while (true);
        return Double.parseDouble(input);
    }
}
