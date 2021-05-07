package bai_tap_them.b5_quanly_canbo.commons;

import bai_tap_them.b5_quanly_canbo.models.CanBo;
import bai_tap_them.b5_quanly_canbo.models.CongNhan;
import bai_tap_them.b5_quanly_canbo.models.KySu;
import bai_tap_them.b5_quanly_canbo.models.NhanVien;

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

    public static List<CanBo> docDanhSach(String tenFile){
        String path = Chung.PATH + tenFile;
        File file = new File(path);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line;
        String[] array;
        List<CanBo> list = new ArrayList<>();
        try{
            if (!file.exists()){
                file.createNewFile();
            }
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            while ((line=bufferedReader.readLine()) != null){
                array = line.split(",");
                if (line.contains("/7")){
                    CanBo congNhan = new CongNhan(array[0],array[1],array[2],array[3],array[4],array[5]);
                    list.add(congNhan);
                } else if (line.contains("PV")){
                    CanBo nhanVien = new NhanVien(array[0],array[1],array[2],array[3], array[4],array[5]);
                    list.add(nhanVien);
                } else {
                    CanBo kySu = new KySu(array[0],array[1],array[2],array[3], array[4],array[5]);
                    list.add(kySu);
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
