package library.Controllers;


import library.commons.FileUtils;
import library.commons.MessageException;
import library.commons.Regex;
import library.models.PhuongTien;

import java.util.List;
import java.util.Scanner;

public class DeleteObject {
    private static Scanner scanner = new Scanner(System.in);
    public static void remove() {
        String chon;
        String input;
        List<PhuongTien> phuongTiens = FileUtils.readList(Regex.FILE_NAME);

        do {
            try {
                System.out.println("CHƯƠNG TRÌNH XÓA PHƯƠNG TIỆN GIAO THÔNG");
                System.out.println("Nhập : ");
                input = scanner.nextLine();
                for (int i = 0; i < phuongTiens.size(); i++) {
                    if (phuongTiens.get(i).getName().equals(input)) {
                        phuongTiens.get(i).showInfo();
                        System.out.println("Bạn có muốn xóa không ?\n" +
                                "1. Yes\n" +
                                "2. No");
                        chon = scanner.nextLine();
                        switch (chon) {
                            case "1":
                                phuongTiens.remove(i);
                                FileUtils.writeList(Regex.FILE_NAME,phuongTiens,false);
                                System.err.println("Xóa thành công");
                                return;
                            case "2":
                                return;
                            default:
                                System.err.println("Vui lòng chọn 1 hoặc 2");
                        }
                    }
                }
                throw new MessageException("Biển kiểm soát không tồn tại.");
            } catch (MessageException e) {
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
        } while (true);
    }
}
