package bai_tap_them.b3_manage_transport2.commons;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TapTin {
    private static final String PATH = "src/bai_tap_them/b3_manage_transport2/data/";

    public static void viet(String noiDung){
        String path = PATH + "phuongTien.csv";
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter(path,true));
            bw.write(noiDung);
            bw.newLine();
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

    public static List<String> doc(){
        String path = PATH + "phuongTien.csv";
        List<String> list = new ArrayList<>();
        File tapTin = new File(path);
        BufferedReader br = null;
        try {
            if (!tapTin.exists()) {
                tapTin.createNewFile();
            }
            br = new BufferedReader(new FileReader(path));
            String line;
            while ((line=br.readLine())!=null){
                list.add(line);
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
        return list;
    }

    public static void xoaFile(){
        String path = PATH + "phuongTien.csv";
        File file = new File(path);
        file.delete();
    }
}
