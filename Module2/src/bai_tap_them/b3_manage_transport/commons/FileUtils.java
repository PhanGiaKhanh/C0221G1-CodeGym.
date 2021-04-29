package bai_tap_them.b3_manage_transport.commons;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static String path = "src/bai_tap_them/b3_manage_transport/data/Vehicle.txt";
    private static final String COMMA = ",";
    public static void writeFile(String content) {
        try{
            FileWriter fw = new FileWriter(path,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.newLine();
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String> readFile(){
        List<String> list = new ArrayList<>();
        try{
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine())!=null) {
                list.add(line);
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void deleteFile(){
        File file = new File(path);
        file.delete();
    }
}
