package bai16_io_text_file.bai_tap.read_file_csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileCSV {
    public static void main(String[] args) {
        String path = "src\\bai16_io_text_file\\bai_tap\\read_file_csv\\file.csv";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine())!=null){
                String[] strings = line.split(",");
                System.out.println(strings[strings.length-1]);
            }
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
