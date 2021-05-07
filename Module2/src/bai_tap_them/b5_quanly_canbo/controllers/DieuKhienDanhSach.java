package bai_tap_them.b5_quanly_canbo.controllers;

import bai_tap_them.b5_quanly_canbo.commons.Chung;
import bai_tap_them.b5_quanly_canbo.commons.DocGhiFile;
import bai_tap_them.b5_quanly_canbo.models.CanBo;
import bai_tap_them.b5_quanly_canbo.models.CongNhan;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DieuKhienDanhSach {
    private static Scanner scanner = new Scanner(System.in);

    public static void hienThi() {
        String chon = "";
        while (true) {
            System.out.println("1.\tThêm cán bộ\n" +
                    "2.\tHiển thị cán bộ\n" +
                    "3.\tTìm kiếm cán bộ\n" +
                    "4.\tChỉnh sửa thông tin\n" +
                    "5.\tSắp xếp theo tên\n" +
                    "6.\tThoát");
            System.out.println("Chọn chức năng (1-6)");
            chon = scanner.nextLine();
            switch (chon) {
                case "1":
                    ThemCanBo.danhSach();
                    break;
                case "2":
                    HienThi.danhSach();
                    break;
                case "3":
                    timKiemTheoTen();
                    break;
                case "4":
                    chinhSuaThongTin();
                    break;
                case "5":
                    sapXepTheoTen();
                    break;
                case "7":
                    xoáCanBo();
                    break;
                case "6":
                    System.err.println("ĐÃ THOÁT");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng nhập từ 1-6");
                    break;
            }
            System.out.println();
        }
    }

    private static void sapXepTheoTen() {
        List<CanBo> canBoList = DocGhiFile.docDanhSach("canBo.csv");
        canBoList.sort(Comparator.comparing(CanBo::getHoTen));
        canBoList.forEach(e->e.showInfo());
    }

    private static void xoáCanBo() {
        List<CanBo> canBoList = DocGhiFile.docDanhSach("canBo.csv");
        String ten = ThemCanBo.them("tên", Chung.NAME_VN);
        CanBo canBo;
        String chon;
        for (int i = 0; i < canBoList.size(); i++) {
            canBo = canBoList.get(i);
            if (canBo.getHoTen().equals(ten)) {
                System.out.println("Bạn muốn xóa thông tin của cán bộ : ");
                canBo.showInfo();
                System.out.println("1. Có\n" +
                        "2. Không\n" +
                        "Chọn 1 hoặc 2");
                chon = scanner.nextLine();
                switch (chon) {
                    case "1":
                        canBoList.remove(Integer.parseInt(chon) - 1);
                        DocGhiFile.vetFile("canBo.csv", canBoList, false);
                        return;
                    case "2":
                        return;
                }
            }
        }
        System.out.println("Không tồn tại tên bạn nhập : " + ten);
    }

    private static void chinhSuaThongTin() {
        List<CanBo> canBoList = DocGhiFile.docDanhSach("canBo.csv");
        String ten = ThemCanBo.them("tên", Chung.NAME_VN);
        CanBo canBo;
        String chon;
        for (int i = 0; i < canBoList.size(); i++) {
            canBo = canBoList.get(i);
            if (canBo.getHoTen().equals(ten)) {
                System.out.println("Bạn muốn chỉnh sửa thông tin của cán bộ : ");
                canBo.showInfo();
                System.out.println("1. Có\n" +
                        "2. Không\n" +
                        "Chọn 1 hoặc 2");
                chon = scanner.nextLine();
                switch (chon) {
                    case "1":
                        if (canBo instanceof CongNhan) {
//                            canBo = ;
                        }
                        DocGhiFile.vetFile("canBo.csv", canBoList, false);
                        return;
                    case "2":
                        return;
                }
            }
        }
        System.out.println("Không tồn tại tên bạn nhập : " + ten);
    }

    private static void timKiemTheoTen() {
        List<CanBo> canBoList = DocGhiFile.docDanhSach("canBo.csv");
        String ten = ThemCanBo.them("tên", Chung.NAME_VN);
        for (CanBo canBo : canBoList) {
            if (canBo.getHoTen().contains(ten)) {
//                System.out.println(canBo);
                canBo.showInfo();
            }
        }
    }
}
