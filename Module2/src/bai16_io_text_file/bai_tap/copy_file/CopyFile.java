package bai16_io_text_file.bai_tap.copy_file;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        String path1 = "src\\bai16_io_text_file\\bai_tap\\copy_file\\file.txt";
        String path2 = "src\\bai16_io_text_file\\bai_tap\\copy_file\\file2.txt";
        FileReader fileReader = new FileReader(path1);
        FileWriter fileWriter2 = new FileWriter(path2, true);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
        String line;
        while ((line = bufferedReader.readLine())!=null){
            bufferedWriter2.write(line);
            bufferedWriter2.write("\n");
//            bufferedWriter2.newLine(); // xuống dòng
        }
        bufferedReader.close();
        bufferedWriter2.flush();
        bufferedWriter2.close();
        fileReader.close();
        fileWriter2.close();
    }
}
