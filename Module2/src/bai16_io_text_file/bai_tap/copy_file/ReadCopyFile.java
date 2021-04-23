package bai16_io_text_file.bai_tap.copy_file;

import java.io.*;

public class ReadCopyFile {
    public static void main(String[] args) throws IOException {
        String path2 = "src\\bai16_io_text_file\\bai_tap\\copy_file\\file2.txt";
        FileReader fileReader = new FileReader(path2);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }
        bufferedReader.close();
        fileReader.close();
    }
}
