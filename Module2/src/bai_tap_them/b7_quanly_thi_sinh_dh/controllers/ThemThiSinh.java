package bai_tap_them.b7_quanly_thi_sinh_dh.controllers;

import bai_tap_them.b7_quanly_thi_sinh_dh.commons.Chung;
import bai_tap_them.b7_quanly_thi_sinh_dh.commons.DocGhiFile;
import bai_tap_them.b7_quanly_thi_sinh_dh.commons.tinNhanException;
import bai_tap_them.b7_quanly_thi_sinh_dh.models.ThiSinh;
import bai_tap_them.b7_quanly_thi_sinh_dh.models.ThiSinhKhoiA;
import bai_tap_them.b7_quanly_thi_sinh_dh.models.ThiSinhKhoiB;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThemThiSinh {
    private static Scanner scanner = new Scanner(System.in);

    public static void danhMuc(){
        String choose = "";
        while (true){
            System.out.println("1.\t Nhập thông tin thí khối A\n" +
                    "2.\t Nhập thông tin thí khối B\n" +
                    "3.\t Nhập thông tin thí khối C\n" +
                    "4.\t Trở lại\n" +
                    "5.\t Thoát");
            System.out.println("Chọn chức năng (1-4)");
            choose = scanner.nextLine();
            switch (choose){
                case "1": thiSinhKhoiA();break;
                case "2": thiSinhKhoiB();break;
                case "3": thiSinhKhoiC();break;
                case "4": return;
                case "5": System.err.println("ĐÃ THOÁT");System.exit(0);break;
                default: System.err.println("Vui lòng nhập từ 1-4");break;
            }
            System.out.println();
        }
    }

    private static void thiSinhKhoiC() {
        String soBaoDanh = id_SBD_0001();
        String hoten = themThuocTinh("họ tên", Chung.NAME_VN, "Nguyễn Văn A");
        String diaChi =  themThuocTinh("địa chỉ", Chung.NAME_VN, "tên đường");
        String uuTien = themThuocTinh("ưu tiên", Chung.UU_TIEN, "Dân tộc thiểu số / Gia đình có công cách mạng");
        String van = themThuocTinh("điểm môn toán", Chung.DIEM,"XX.XX vời X từ 0 đến 9");
        String su = themThuocTinh("điểm môn lý", Chung.DIEM,"XX.XX vời X từ 0 đến 9");
        String dia = themThuocTinh("điểm môn hóa", Chung.DIEM,"XX.XX vời X từ 0 đến 9");
        ThiSinh thiSinhKhoiB = new ThiSinhKhoiB(soBaoDanh,hoten,diaChi,uuTien,van,su,dia);
        List<ThiSinh> danhSach = new ArrayList<>();
        danhSach.add(thiSinhKhoiB);
        DocGhiFile.vetFile(Chung.FILE_NAME,danhSach,true);
    }

    private static void thiSinhKhoiB() {
        String soBaoDanh = id_SBD_0001();
        String hoten = themThuocTinh("họ tên", Chung.NAME_VN, "Nguyễn Văn A");
        String diaChi =  themThuocTinh("địa chỉ", Chung.NAME_VN, "tên đường");
        String uuTien = themThuocTinh("ưu tiên", Chung.UU_TIEN, "Dân tộc thiểu số / Gia đình có công cách mạng");
        String toan = themThuocTinh("điểm môn toán", Chung.DIEM,"XX.XX vời X từ 0 đến 9");
        String hoa = themThuocTinh("điểm môn lý", Chung.DIEM,"XX.XX vời X từ 0 đến 9");
        String sinh = themThuocTinh("điểm môn hóa", Chung.DIEM,"XX.XX vời X từ 0 đến 9");
        ThiSinh thiSinhKhoiB = new ThiSinhKhoiB(soBaoDanh,hoten,diaChi,uuTien,toan,hoa,sinh);
        List<ThiSinh> danhSach = new ArrayList<>();
        danhSach.add(thiSinhKhoiB);
        DocGhiFile.vetFile(Chung.FILE_NAME,danhSach,true);
    }

    private static void thiSinhKhoiA() {
        String soBaoDanh = id_SBD_0001();
        String hoten = themThuocTinh("họ tên", Chung.NAME_VN, "Nguyễn Văn A");
        String diaChi =  themThuocTinh("địa chỉ", Chung.NAME_VN, "tên đường");
        String uuTien = themThuocTinh("ưu tiên", Chung.UU_TIEN, "Dân tộc thiểu số / Gia đình có công cách mạng");
        String toan = themThuocTinh("điểm môn toán", Chung.DIEM,"XX.XX vời X từ 0 đến 9");
        String ly = themThuocTinh("điểm môn lý", Chung.DIEM,"XX.XX vời X từ 0 đến 9");
        String hoa = themThuocTinh("điểm môn hóa", Chung.DIEM,"XX.XX vời X từ 0 đến 9");
        ThiSinh thiSinhKhoiA = new ThiSinhKhoiA(soBaoDanh,hoten,diaChi,uuTien,toan,ly,hoa);
        List<ThiSinh> danhSach = new ArrayList<>();
        danhSach.add(thiSinhKhoiA);
        DocGhiFile.vetFile(Chung.FILE_NAME,danhSach,true);
    }
    public static String id_SBD_0001() {
        String ma = "SBD-";
        String regex = "^SBD-[0-9]{4}$";
        List<ThiSinh> lists = DocGhiFile.docDanhSach(Chung.FILE_NAME);
        String id = "";
        while (true) {
            id = ma + (lists.size() + 1);
            if (id.matches(regex)) {
                break;
            }
            ma += 0;
            id = "";
        }
        return id;
    }
    public static String themThuocTinh(String thuocTinh, String regex, String tinNhan) {
        String input = null;
        while (true) {
            try {
                System.out.println("Nhập " + thuocTinh + " (" + tinNhan + " )");
                input = scanner.nextLine();
                if (!input.matches(regex)) {
                    throw new tinNhanException("Lỗi định dạng " + thuocTinh + ": " + regex);
                }
                return input;
            } catch (tinNhanException v) {
                System.err.println(v.getMessage());
            }
        }
    }
}
