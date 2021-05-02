package bai_tap_them.b3_manage_transport2.controllers;

import bai_tap_them.b3_manage_transport2.commons.HienThi;
import bai_tap_them.b3_manage_transport2.commons.TapTin;
import bai_tap_them.b3_manage_transport2.commons.ThemMoi;
import bai_tap_them.b3_manage_transport2.models.PhuongTien;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChucNang {
    private static Scanner scanner = new Scanner(System.in);
    public static void themMoiPhuongTien(){
        byte choose;
        do {
            try {
                System.out.println("CHƯƠNG TRÌNH THÊM MỚI PHƯƠNG TIỆN");
                System.out.println("1. Thêm xe tải\n" +
                        "2. Thêm ôtô \n" +
                        "3. Thêm  xe máy\n" +
                        "4. Quay lại\n" +
                        "5. Thoát");
                System.out.println("-------Chọn chức năng (1-5)-------");
                choose = Byte.parseByte(scanner.nextLine());
                switch (choose){
                    case 1: ThemMoi.xeTai();break;
                    case 2: ThemMoi.oto();break;
                    case 3: ThemMoi.xeMay();break;
                    case 4: return;
                    case 5: System.exit(0);break;
                    default: System.err.println("----------Yêu cầu nhập 1-5----------");break;
                }
                if (String.valueOf(choose).matches("^\\D$")){
                    throw new Exception("Lỗi nhập");
                }
            }catch (Exception e){
                System.err.println("Lỗi nhập:  "+ e);
            }
        }while (true);
    }
    public static void hienThiPhuongTien(){
        byte choose;
        do {
            try {
                System.out.println("CHƯƠNG TRÌNH HIỂN THỊ PHƯƠNG TIỆN");
                System.out.println("1. Hiện thị xe tải.\n" +
                        "2. Hiện thị ôtô. \n" +
                        "3. Hiện  xe máy\n" +
                        "4. Quay lại\n" +
                        "5. Thoát");
                System.out.println("-------Chọn chức năng (1-5)-------");
                choose = Byte.parseByte(scanner.nextLine());
                switch (choose){
                    case 1: HienThi.xeTai();break;
                    case 2: HienThi.oto();break;
                    case 3: HienThi.xeMay();break;
                    case 4: return;
                    case 5: System.exit(0);break;
                    default: System.err.println("----------Yêu cầu nhập 1-5----------");break;
                }
                if (String.valueOf(choose).matches("^\\D$")){
                    throw new Exception("Lỗi nhập");
                }
            }catch (Exception e){
                System.err.println("Lỗi nhập:  "+ e);
            }
        }while (true);
    }
    public static void xoaPhuongTien(){
        byte choose;
        String bienkiemSoat = null;
        String[] thongTinXe;
        do {
            try {
                System.out.println("CHƯƠNG TRÌNH XÓA PHƯƠNG TIỆN");
                System.out.println("Nhập biển kiểm soát");
                bienkiemSoat = scanner.nextLine();
                boolean isNotFound = true;
                List<String> listXe = new ArrayList<>();
                List<String> thongTin = new ArrayList<>();
                for (String xe : TapTin.doc()){
                    thongTinXe = xe.split(",");
                    if (thongTinXe[0].equals(bienkiemSoat)){
                        thongTin.add(xe);
                        isNotFound = false;
                        continue;
                    }
                    listXe.add(xe);
                }
                if (isNotFound){
                    throw new Exception("Không tồn tại biển số xe bạn nhập  " + bienkiemSoat);
                }else {
                    System.out.println("Bạn có muốn xóa " + thongTin);
                    System.out.println("1.YES\n" +
                            "2.NO");
                    switch (scanner.nextLine()){
                        case "1": TapTin.xoaFile();listXe.forEach(e->TapTin.viet(e));break;
                        case "2": return;
                        default:
                            System.err.println("Chọn 1/2");break;
                    }
//                    listXe.clear();
                    System.out.println("Xóa thành công");
                    return;
                }
            }catch (Exception e){
                System.err.println("  Lỗi nhập:  "+ e);
            }
        }while (true);
    }
}
