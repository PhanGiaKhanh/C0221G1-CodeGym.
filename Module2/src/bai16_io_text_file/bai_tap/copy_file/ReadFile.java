package bai16_io_text_file.bai_tap.copy_file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String path1 = "src\\bai16_io_text_file\\bai_tap\\copy_file\\file.txt";
        FileReader fileReader = new FileReader(path1);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line=bufferedReader.readLine())!=null) {
            System.out.println(line);
        }
        bufferedReader.close();
        fileReader.close();
    }
}
