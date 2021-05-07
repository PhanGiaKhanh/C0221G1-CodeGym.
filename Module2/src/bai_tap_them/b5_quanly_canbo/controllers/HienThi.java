package bai_tap_them.b5_quanly_canbo.controllers;

import bai_tap_them.b5_quanly_canbo.commons.DocGhiFile;
import bai_tap_them.b5_quanly_canbo.models.CanBo;
import bai_tap_them.b5_quanly_canbo.models.CongNhan;
import bai_tap_them.b5_quanly_canbo.models.KySu;
import bai_tap_them.b5_quanly_canbo.models.NhanVien;

import java.util.List;
import java.util.Scanner;

public class HienThi {
    private static Scanner scanner = new Scanner(System.in);

    public static void danhSach(){
        String chon = "";
        while (true){
            System.out.println("1. công nhân\n" +
                    "2. kỹ sư\n" +
                    "3. nhân viên\n" +
                    "4. trở lại\n" +
                    "5. Thoát");
            System.out.println("Chọn chức năng (1-6)");
            chon = scanner.nextLine();
            switch (chon){
                case "1": congNhan();break;
                case "2": kySu();break;
                case "3": nhanVien();break;
                case "4": return;
                case "5": System.err.println("ĐÃ THOÁT");System.exit(0);break;
                default: System.err.println("Vui lòng nhập từ 1-6");break;
            }
            System.out.println();
        }
    }

    private static void nhanVien() {
        List<CanBo> danhSach = DocGhiFile.docDanhSach("canBo.csv");
        for (CanBo canbo : danhSach) {
            if (canbo instanceof NhanVien){
                canbo.showInfo();
//                System.out.println();
            }
        }
    }

    private static void kySu() {
        List<CanBo> danhSach = DocGhiFile.docDanhSach("canBo.csv");
        for (CanBo canbo : danhSach) {
            if (canbo instanceof KySu){
                canbo.showInfo();
//                System.out.println();
            }
        }
    }

    private static void congNhan() {
        List<CanBo> danhSach = DocGhiFile.docDanhSach("canBo.csv");
        for (CanBo canbo : danhSach) {
            if (canbo instanceof CongNhan){
                canbo.showInfo();
//                System.out.println();
            }
        }
    }
}
