package library.Controllers;

import java.time.Year;
import java.util.Scanner;

public class DayOfBirth2 {

    public static void main(String[] args) {
        while (true) {
            System.out.println(Year.now());
            checkBirthDay();
        }
    }

    public static String checkBirthDay() {
        String kiemTraNgayNhap = "^(?:(?:31(\\/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        String nhap = null;
        while (true) {
            try {
                System.out.println("Nhập ngày tháng năm sinh muốn kiểm tra");
                nhap = new Scanner(System.in).nextLine();
                int namSinh = Integer.parseInt(nhap.split("/")[2]);
                int namHienTai = Year.now().getValue();
                if (!nhap.matches(kiemTraNgayNhap)) {
                    throw new Exception();
                } else if (namSinh <= 1900 || namHienTai - 18 < namSinh || namSinh - namHienTai > 1) {
                    throw new Exception();
                }
                System.out.println("Nhập thành công: " + nhap);
                return nhap;
            } catch (Exception e) {
                System.err.println("Nhập sai định dạng DD/MM/YYYY hoặc ngày không tồn tại");
            }
        }
    }
}
