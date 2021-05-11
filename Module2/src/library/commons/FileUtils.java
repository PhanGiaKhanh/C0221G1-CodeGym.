package library.commons;

import bai_tap_them.b3_manage_transport3.models.Vehicle;
import library.models.Oto;
import library.models.PhuongTien;
import library.models.XeMay;
import library.models.XeTai;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static final String PATH = "";

    public static <T> void writeList(String fileName, List<T> lists, boolean status) {
        String path = PATH + fileName;
        FileWriter fileWriter = null;
        BufferedWriter bw = null;
        try {
            fileWriter = new FileWriter(path, status);
            bw = new BufferedWriter(fileWriter);
            for (T phuongTien : lists) {
                bw.write(phuongTien.toString());
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fileWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeString(String fileName, String string, boolean status) {
        String path = PATH + fileName;
        FileWriter fileWriter = null;
        BufferedWriter bw = null;
        try {
            fileWriter = new FileWriter(path, status);
            bw = new BufferedWriter(fileWriter);
            bw.write(string);
            bw.newLine();

            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fileWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<PhuongTien> readList(String fileName) {
        String path = PATH + fileName;
        File file = null;
        List<PhuongTien> list = new ArrayList<>();
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
                if (strings.length == 6) {
                    PhuongTien oto = new Oto(strings);
                    list.add(oto);
                } else if (strings.length == 5 && strings[0].contains("C")) {
                    PhuongTien xeTai = new XeTai(strings);
                    list.add(xeTai);
                } else if (strings.length == 5 && !strings[0].contains("C")) {
                    PhuongTien xeMay = new XeMay(strings);
                    list.add(xeMay);
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

    public static List<String> readManufacturer(String fileName) {
        String path = PATH + fileName;
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
