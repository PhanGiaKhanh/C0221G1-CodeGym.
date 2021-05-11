package library.Controllers;

import library.commons.MessageException;
import library.commons.Regex;

import javax.swing.*;
import java.util.Scanner;

public class AddObject {
    private static Scanner scanner = new Scanner(System.in);

    public static String add(String property, String regex) {
        String input = null;
        while (true) {
            try {
                System.out.println("Nhập " + property + ": " + regex);
                input = scanner.nextLine();
                if (!input.matches(regex)) {
                    throw new MessageException("Lỗi định dạng " + property + ": " + regex);
                }
                return input;
            } catch (MessageException v) {
                System.err.println(v.getMessage());
            }
        }
    }

    public static String add(String property, String regex, String message) {
        String input = null;
        while (true){
            try {
                System.out.println("Nhập " + property + ": " + message);
                input = scanner.nextLine();
                if (!input.matches(regex)) {
                    throw new MessageException("Lỗi định dạng " + property + ": " + regex);
                }
                return input;
            } catch (MessageException v) {
                System.err.println(v.getMessage());
            }
        }
    }

    public static String kiemTraNgoaiLeNhapVao(String property, String regex, Exception exception) {
        String nhapThuocTinh;
        do {
            try {
                System.out.println("Nhập: " + property);
                nhapThuocTinh = new Scanner(System.in).nextLine();
                if (!nhapThuocTinh.matches(regex)) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.err.println(exception.getMessage());
                System.err.println("Lỗi định dạng: " + regex + "\nNhập lại: ");
            }
        } while (true);
        return nhapThuocTinh;
    }

    public static void main(String[] args) {
        kiemTraNhapVaoTheoDinhDang("ten", Regex.NAME_VN,"Nhập sai tên","chữ cái");
    }
    public static String kiemTraNhapVaoTheoDinhDang(String thuocTinh, String regex, String tinNhan,String dinhDang) {
        String nhap = null;
        JOptionPane jOptionPane=new JOptionPane();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Nhập " + thuocTinh);
                nhap = scanner.nextLine();
                if (!nhap.matches(regex)) {
                    JOptionPane.showMessageDialog(jOptionPane,tinNhan,"Lỗi",JOptionPane.ERROR_MESSAGE);
                    throw new MessageException(tinNhan+"\nVui lòng nhập lại theo định dạng: "+dinhDang);
                }
                return nhap;
            } catch (MessageException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
