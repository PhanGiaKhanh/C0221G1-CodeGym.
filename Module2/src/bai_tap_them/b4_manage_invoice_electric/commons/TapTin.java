package bai_tap_them.b4_manage_invoice_electric.commons;

import bai_tap_them.b4_manage_invoice_electric.models.HoaDonTienDIen;
import bai_tap_them.b4_manage_invoice_electric.models.KhachHang;
import bai_tap_them.b4_manage_invoice_electric.models.KhachNuocNgoai;
import bai_tap_them.b4_manage_invoice_electric.models.KhachVietNam;
import library.models.Oto;
import library.models.PhuongTien;
import library.models.XeMay;
import library.models.XeTai;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TapTin {
    private static final String PATH = "src/bai_tap_them/b4_manage_invoice_electric/data/";

    public static <T> void viet(String tenTapTin, List<T> danhSach, boolean trangThai) {
        String path = PATH + tenTapTin;
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(path, trangThai));
            for (T phanTu : danhSach) {
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


    public static List<String> docHoaDon(String tenTapTin) {
        List<String> danhSach = new ArrayList<>();
        File file = new File(PATH + tenTapTin);
        FileReader fileReader = null;
        BufferedReader br = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fileReader = new FileReader(file);
            br = new BufferedReader(fileReader);
            String line;
            while ((line = br.readLine()) != null) {
                danhSach.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return danhSach;
    }


    public static List<KhachHang> docKhachHang(String tenTapTin) {
        String path = PATH + tenTapTin;
        File file = null;
        List<KhachHang> list = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader br = null;
        String line = null;
        String[] strings = null;
        try {
            file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            fileReader = new FileReader(path);
            br = new BufferedReader(fileReader);
            while ((line = br.readLine()) != null) {
                strings = line.split(",");
                if(strings.length==4){
                    list.add(new KhachVietNam(strings[0],strings[1],strings[2],strings[3]));
                }else if (strings.length == 3) {
                    list.add(new KhachNuocNgoai(strings[0],strings[1],strings[2]));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

}
