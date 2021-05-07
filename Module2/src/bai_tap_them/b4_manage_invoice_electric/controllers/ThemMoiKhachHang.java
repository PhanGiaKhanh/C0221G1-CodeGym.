package bai_tap_them.b4_manage_invoice_electric.controllers;

import bai_tap_them.b3_manage_transport3.commons.VehicleValidate;
import bai_tap_them.b4_manage_invoice_electric.commons.TapTin;
import bai_tap_them.b4_manage_invoice_electric.models.KhachHang;
import bai_tap_them.b4_manage_invoice_electric.models.KhachNuocNgoai;
import bai_tap_them.b4_manage_invoice_electric.models.KhachVietNam;
import case_study.commons.Common;
import case_study.commons.FileUtils;
import case_study.models.Room;
import case_study.models.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThemMoiKhachHang {
    private static Scanner scanner = new Scanner(System.in);

    public static void danhMucThem() {
        String choose;
        while (true) {
            System.out.println("CHƯƠNG TRÌNH THÊM KHÁCH HÀNG\n" +
                    "Chọn chức năng:\n" +
                    "1. Thêm khách hàng VN,\n" +
                    "2. Thêm khách hàng nước ngoài, \n" +
                    "3. Quay lại danh mục chính\n" +
                    "4. Thoát");
            System.out.println("-------Chọn chức năng (1-4)-------");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    themKhachHangVN();
                    break;
                case "2":
                    themKhachHangNN();
                    break;
                case "3":
                    return;
                case "4":
                    System.err.println("ĐÃ THOÁT");
                    System.exit(0);
                default:
                    System.err.println("Vui long nhập từ 1-4");
                    break;
            }
        }
    }

    public static void themKhachHangVN() {
        String maKhachHang = id_KHVN_0001();
        String tenKhachHang = add("họ tên", Chung.NAME);
        String loaiKhachHang = themLoaiKhachHang();
        String dinhMucTieuThu = add("định mức tiêu thụ", Chung.NUMBER);

        KhachHang khachHangVN = new KhachVietNam(maKhachHang, tenKhachHang, loaiKhachHang, dinhMucTieuThu);
        List<KhachHang> list = new ArrayList<>();
        list.add(khachHangVN);
        TapTin.viet("data.csv", list, true);
    }

    public static void themKhachHangNN() {
        String maKhachHang = id_KHNN_0001();
        String tenKhachHang = add("họ tên", Chung.NAME);
        String quocTich = add("quốc tịch", Chung.NAME);
        KhachHang khachHangNN = new KhachNuocNgoai(maKhachHang, tenKhachHang, quocTich);
        List<KhachHang> list = new ArrayList<>();
        list.add(khachHangNN);
        TapTin.viet("data.csv", list, true);
    }

    public static String add(String property, String regex) {
        String input = null;
        do {
            try {
                System.out.println("Nhập " + property + ": ");
                input = scanner.nextLine();
                VehicleValidate.checkFormat(property, input, regex);
                break;
            } catch (VehicleValidate v) {
                System.err.println(v.getMessage());
            }
        } while (true);
        return input;
    }

    public static String id_KHVN_0001() {
        String ma = "KHVN-";
        String regex = "^KHVN-[0-9]{4}$";

        List<KhachHang> lists = TapTin.docKhachHang("data.csv");
        System.out.println(lists);
        List<KhachHang> objects = new ArrayList<>();
        for (KhachHang list : lists) {
            if (list instanceof KhachVietNam) {
                objects.add(list);
            }
        }
        String id = "";
        while (true) {
            id = ma + (objects.size() + 1);
            if (id.matches(regex)) {
                break;
            }
            ma += 0;
            id = "";
        }
        return id;
    }


    public static String id_KHNN_0001() {
        String ma = "KHNN-";
        String regex = "^KHNN-[0-9]{4}$";
        List<KhachHang> danhSach = TapTin.docKhachHang("data.csv");
        List<KhachHang> objects = new ArrayList<>();
        for (KhachHang phanTu : danhSach) {
            if (phanTu instanceof KhachVietNam) {
                objects.add(phanTu);
            }
        }
        String id = "";
        while (true) {
            id = ma + (objects.size() + 1);
            if (id.matches(regex)) {
                break;
            }
            ma += 0;
            id = "";
        }
        return id;
    }

    public static String themLoaiKhachHang() {
        String result;
        String choose;

        while (true) {
            System.out.println("Thêm loại khách hàng");
            List<String> danhSach = TapTin.docHoaDon("loaiKhach.csv");
            for (int i = 0; i < danhSach.size(); i++) {
                System.out.println((i + 1) + ". " + danhSach.get(i));
            }
            System.out.println("Chọn từ 1 - " + danhSach.size());
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    return result = danhSach.get(0).split(",")[1];
                case "2":
                    return result = danhSach.get(1).split(",")[1];
                case "3":
                    return result = danhSach.get(2).split(",")[1];
                case "4":
                    System.err.println("ĐÃ THOÁT");
                    System.exit(0);
                default:
                    System.err.println("Vui long nhập từ 1-4");
                    break;
            }
        }
    }
}
