package bai_tap_them.b7_quanly_thi_sinh_dh.commons;


import bai_tap_them.b7_quanly_thi_sinh_dh.models.ThiSinh;
import bai_tap_them.b7_quanly_thi_sinh_dh.models.ThiSinhKhoiA;
import bai_tap_them.b7_quanly_thi_sinh_dh.models.ThiSinhKhoiB;
import bai_tap_them.b7_quanly_thi_sinh_dh.models.ThiSinhKhoiC;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DocGhiFile {
    public static <T> void vetFile(String tenFile, List<T> danhSach, boolean trangThai){
        String path = Chung.PATH + tenFile;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try{
            fileWriter = new FileWriter(path, trangThai);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (T phanTu : danhSach){
                bufferedWriter.write(phanTu.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<ThiSinh> docDanhSach(String tenFile){
        String path = Chung.PATH + tenFile;
        File file = new File(path);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line;
        String[] array;
        List<ThiSinh> list = new ArrayList<>();
        try{
            if (!file.exists()){
                file.createNewFile();
            }
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            while ((line=bufferedReader.readLine()) != null){
                array = line.split(",");
                if (array[1].equals("1")){
                    ThiSinh khoiA = new ThiSinhKhoiA(array[0],array[2],array[3],array[4],array[5],array[6],array[7]);
                    list.add(khoiA);
                } else if (array[1].equals("2")){
                    ThiSinh khoiB = new ThiSinhKhoiB(array[0],array[2],array[3],array[4],array[5],array[6],array[7]);
                    list.add(khoiB);
                } else if (array[1].equals("3")){
                    ThiSinh khoiC = new ThiSinhKhoiC(array[0],array[2],array[3],array[4],array[5],array[6],array[7]);
                    list.add(khoiC);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static List<String> docNganhDaoTao(String fileName) {
        String path = Chung.PATH + fileName;
        List<String> list = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader br = null;
        String line = null;
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            fileReader = new FileReader(path);
            br = new BufferedReader(fileReader);
            while ((line = br.readLine()) != null) {
                list.add(line);
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
