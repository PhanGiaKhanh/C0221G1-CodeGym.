package bai_tap_them.b4_manage_invoice_electric.commons;

import bai_tap_them.b4_manage_invoice_electric.models.HoaDonTienDIen;
import bai_tap_them.b4_manage_invoice_electric.models.KhachNuocNgoai;
import bai_tap_them.b4_manage_invoice_electric.models.KhachVietNam;

import java.io.*;
import java.util.List;

public class TapTin {
    private  static  final String PATH = "src/bai_tap_them/b4_manage_invoice_electric/data";
    public static void vietTapTin(String tenTapTin, List<HoaDonTienDIen> danhSach, boolean writeStatus){
        String path = PATH + tenTapTin;
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter(path, writeStatus));
            for (HoaDonTienDIen con : danhSach){
                bw.write(con.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static List<HoaDonTienDIen> docTapTinVietNam(String tenTapTin){
        List<HoaDonTienDIen> danhSach = null;
        File file = new File(PATH + tenTapTin);
        String[] temps;
        BufferedReader br = null;
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            br = new BufferedReader(new FileReader(file));
            String line;
            KhachVietNam khachVietNam;
            while ((line = br.readLine()) != null){
                temps = line.split(",");
                if (temps.length==9) {
                    khachVietNam = new KhachVietNam(temps);
                    danhSach.add(khachVietNam);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return danhSach;
    }
    public static List<HoaDonTienDIen> docTapTinNuocNgoai(String tenTapTin){
        List<HoaDonTienDIen> danhSach = null;
        File file = new File(PATH + tenTapTin);
        String[] temps;
        BufferedReader br = null;
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            br = new BufferedReader(new FileReader(file));
            String line;
            KhachNuocNgoai khachNuocNgoai;
            while ((line = br.readLine()) != null){
                temps = line.split(",");
                if (temps.length==8) {
                    khachNuocNgoai = new KhachNuocNgoai(temps);
                    danhSach.add(khachNuocNgoai);
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
}
