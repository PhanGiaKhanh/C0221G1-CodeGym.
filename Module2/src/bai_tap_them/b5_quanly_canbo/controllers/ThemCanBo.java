package bai_tap_them.b5_quanly_canbo.controllers;

import bai_tap_them.b5_quanly_canbo.commons.Chung;
import bai_tap_them.b5_quanly_canbo.commons.DocGhiFile;
import bai_tap_them.b5_quanly_canbo.models.CanBo;
import bai_tap_them.b5_quanly_canbo.models.CongNhan;
import bai_tap_them.b5_quanly_canbo.models.KySu;
import bai_tap_them.b5_quanly_canbo.models.NhanVien;
import case_study.commons.FileUtils;
import case_study.models.Room;
import case_study.models.Service;
import library.commons.MessageException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThemCanBo {
    private static Scanner scanner = new Scanner(System.in);

    public static void danhSach(){
        String chon = "";
        while (true){
            System.out.println("1.\tNhập thông tin kỹ sư\n" +
                    "2.\tNhập thông tin nhân viên\n" +
                    "3.\tNhập thông tin công nhân\n" +
                    "4.\tTrở lại menu chính\n" +
                    "5.\tThoát" );
            System.out.println("Chọn chức năng (1-5)");
            chon = scanner.nextLine();
            switch (chon){
                case "1": themCanBo("kySu");break;
                case "2": themCanBo("nhanVien");break;
                case "3": themCanBo("congNhan");break;
                case "4": return;
                case "5": System.err.println("ĐÃ THOÁT");System.exit(0);break;
                default: System.err.println("Vui lòng nhập từ 1-5");break;
            }
            System.out.println();
        }
    }
    public static void themCanBo(String loaiCanBo){
        String id = id_CB_001();
        String hoTen = them("họ tên", Chung.NAME_VN);
        String ngaySinh = them("ngày sinh", Chung.REGEX_DAY);
        String gioiTinh = them("giới tính", Chung.GENDER);
        String diaChi = them("địa chỉ", Chung.NAME_VN);
        List<CanBo> danhSach = danhSach = new ArrayList<>();
        if (loaiCanBo.equals("nhanVien")) {
            String congViec = them("công việc", Chung.NHAN_VIEN);
            CanBo nhanVien = new NhanVien(id,hoTen,ngaySinh,gioiTinh,diaChi,congViec);
            danhSach.add(nhanVien);
        } else if(loaiCanBo.equals("kySu")){
            String nganhDaoTao = nganhDaoTao().split(",")[1];
            CanBo kySu = new KySu(id,hoTen,ngaySinh,gioiTinh,diaChi,nganhDaoTao);
            danhSach.add(kySu);
        } else if(loaiCanBo.equals("congNhan")){
            String bacCongNhan =them("bậc công nhân", Chung.CONG_NHAN);
            CanBo congNhan = new CongNhan(id,hoTen,ngaySinh,gioiTinh,diaChi,bacCongNhan);
            danhSach.add(congNhan);
        }
        DocGhiFile.vetFile("canBo.csv", danhSach, true);
    }
    public static void themNhanVien() {
        String id = id_CB_001();
        String hoTen = them("họ tên", Chung.NAME_VN);
        String ngaySinh = them("ngày sinh", Chung.REGEX_DAY);
        String gioiTinh = them("giới tính", Chung.GENDER);
        String diaChi = them("địa chỉ", Chung.NAME_VN);
        String congViec = them("công việc", Chung.NHAN_VIEN);
        CanBo nhanVien = new NhanVien(id,hoTen,ngaySinh,gioiTinh,diaChi,congViec);
        List<CanBo> danhSach = new ArrayList<>();
        danhSach.add(nhanVien);
        DocGhiFile.vetFile("canBo.csv", danhSach, true);
    }

    public static void themKySu(){
        String id = id_CB_001();
        String hoTen = them("họ tên", Chung.NAME_VN);
        String ngaySinh = them("ngày sinh", Chung.REGEX_DAY);
        String gioiTinh = them("giới tính", Chung.GENDER);
        String diaChi = them("địa chỉ", Chung.NAME_VN);
        String nganhDaoTao = nganhDaoTao().split(",")[1];
        CanBo kySu = new KySu(id,hoTen,ngaySinh,gioiTinh,diaChi,nganhDaoTao);
        List<CanBo> danhSach = new ArrayList<>();
        danhSach.add(kySu);
        DocGhiFile.vetFile("canBo.csv", danhSach, true);
    }
    public static void themCongNhan(){
        String id = id_CB_001();
        String hoTen = them("họ tên", Chung.NAME_VN);
        String ngaySinh = them("họ tên", Chung.REGEX_DAY);
        String gioiTinh = them("họ tên", Chung.GENDER);
        String diaChi = them("họ tên", Chung.NAME_VN);
        String bacCongNhan =them("bậc công nhân", Chung.CONG_NHAN);
        CanBo congNhan = new CongNhan(id,hoTen,ngaySinh,gioiTinh,diaChi,bacCongNhan);
        List<CanBo> danhSach = new ArrayList<>();
        danhSach.add(congNhan);
        DocGhiFile.vetFile("canBo.csv", danhSach, true);
    }

    private static void viet(CanBo congNhan) {
        List<CanBo> danhSach = new ArrayList<>();
        danhSach.add(congNhan);
        DocGhiFile.vetFile("canBo.csv", danhSach, true);
    }

    public static String nganhDaoTao(){
        String nganhDaoTao = null;
        String chon;
        List<String> danhSach = DocGhiFile.docNganhDaoTao("nganhDaoTao.csv");
        for (int i = 0; i < danhSach.size(); i++) {
            System.out.println((i+1) + ". " + danhSach.get(i));
        }
        System.out.println("Chọn 1 -" + danhSach.size());
        while (true) {
            chon = scanner.nextLine();
            switch (chon) {
                case "1":
                case "2":
                case "3":
                    return danhSach.get(Byte.parseByte(chon) - 1);
                default:
                    System.err.println("Vui long nhập từ 1-" + danhSach.size());
            }
        }
    }
    public static String id_CB_001() {
        String ma = "CB-";
        String regex = "^CB-[0-9]{3}$";
        List<CanBo> lists = DocGhiFile.docDanhSach("canBo.csv");
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
    public static String them(String property, String regex) {
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
}
