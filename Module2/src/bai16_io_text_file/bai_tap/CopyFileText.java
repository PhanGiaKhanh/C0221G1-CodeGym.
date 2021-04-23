package bai16_io_text_file.bai_tap;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileText {
    public static void main(String[] args) throws IOException {
        // tạo thư mục hello
        File file = new File("src\\bai16_io_text_file\\bai_tap\\hello");
        file.mkdir();

        // tạo test.txt
//        FileWriter f = new FileWriter("src\\bai16_io_text_file\\bai_tap\\hello\\test.txt");
//        f.write("hello");
//        f.close();
//        FileReader fileReader = new FileReader("src\\bai16_io_text_file\\bai_tap\\hello\\test.txt");

        File f = new File("src\\bai16_io_text_file\\bai_tap\\hello\\test.txt");
        if (!f.exists()){
            f.createNewFile();
        }

        // hiển thị nội dung test.txt
        FileReader fileReader = new FileReader(f);
        int c = fileReader.read();
        while (c!=-1){
            System.out.print((char) c);
            c = fileReader.read();
        }

        fileReader.close();

        String s = "Trung tam java";
        FileWriter fileWriter = new FileWriter(f);
        fileWriter.write(s);
        fileWriter.close();
    }
}
