package bai_tap_them.b4_manage_invoice_electric.commons;

import bai_tap_them.b4_manage_invoice_electric.models.HoaDonTienDIen;
import bai_tap_them.b4_manage_invoice_electric.models.KhachNuocNgoai;
import bai_tap_them.b4_manage_invoice_electric.models.KhachVietNam;

import java.io.*;
import java.util.List;

public class TapTin {
    private static final String PATH = "src/bai_tap_them/b4_manage_invoice_electric/data";

    public static void viet(String tenTapTin, List<HoaDonTienDIen> danhSach, boolean trangThai) {
        String path = PATH + tenTapTin;
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(path, trangThai));
            for (HoaDonTienDIen phanTu : danhSach) {
                bw.write(phanTu.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<HoaDonTienDIen> doc(String tenTapTin) {
        List<HoaDonTienDIen> danhSach = null;
        File file = new File(PATH + tenTapTin);
        String[] temps;
        BufferedReader br = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            br = new BufferedReader(new FileReader(file));
            String line;
            HoaDonTienDIen khachVietNam;
            HoaDonTienDIen khachNuocNgoai;
            while ((line = br.readLine()) != null) {
                temps = line.split(",");
                if (temps.length == 9) {
//                    khachVietNam = new KhachVietNam(temps[]);
//                    danhSach.add(khachVietNam);
                }
                if (temps.length == 8) {
//                    khachNuocNgoai = new KhachNuocNgoai(temps);
//                    danhSach.add(khachNuocNgoai);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return danhSach;
    }

    public static List<String> docHoaDon(String tenTapTin) {
        List<String> danhSach = null;
        File file = new File(PATH + tenTapTin);
        BufferedReader br = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                danhSach.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return danhSach;
    }

}
