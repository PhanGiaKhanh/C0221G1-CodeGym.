package bai16_io_text_file.bai_tap.copy_file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void main(String[] args) throws IOException {
        File f = new File("src\\bai16_io_text_file\\bai_tap\\copy_file\\file.txt");
        FileWriter fileWriter = new FileWriter(f, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write("hello guys");
        bufferedWriter.write("\ni love you so much");
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();
    }
}
