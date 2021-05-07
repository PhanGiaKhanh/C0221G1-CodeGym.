package library.Controllers;

import library.commons.FileUtils;
import library.commons.MessageException;
import library.commons.Regex;
import library.models.PhuongTien;

import java.util.List;
import java.util.Scanner;

public class EditObject {
    private static Scanner scanner = new Scanner(System.in);
    public static void remove() {
        String choose;
        String input;
        List<PhuongTien> phuongTiens = FileUtils.readList(Regex.FILE_NAME);
        while (true) {
            System.out.println("CHƯƠNG TRÌNH CHỈNH SỬA PHƯƠNG TIỆN GIAO THÔNG");
            System.out.println("Nhập : ");
            input = scanner.nextLine();
            for (int i = 0; i < phuongTiens.size(); i++) {
                if (phuongTiens.get(i).getName().equals(input)) {
                    phuongTiens.get(i).showInfo();
                    System.out.println("Bạn có muốn chỉnh sửa không ?\n" +
                            "1. Yes\n" +
                            "2. No");
                    choose = scanner.nextLine();
                    switch (choose) {
                        case "1":

                            phuongTiens.get(i).setName(AddObject.add("tên", Regex.NAME_VN));

                            FileUtils.writeList(Regex.FILE_NAME, phuongTiens, false);
                            System.err.println("Chỉnh sửa thành công");
                            return;
                        case "2":
                            return;
                    }
                }
            }
        }
    }
}
