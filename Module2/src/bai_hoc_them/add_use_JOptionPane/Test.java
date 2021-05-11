package bai_hoc_them.add_use_JOptionPane;



import library.commons.MessageException;
import library.commons.Regex;

import javax.swing.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        kiemTraNhapVaoTheoDinhDang("ten",Regex.NAME_VN,"Nhập sai tên","chữ cái");
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
