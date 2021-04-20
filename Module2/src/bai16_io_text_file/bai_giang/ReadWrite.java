package bai16_io_text_file.bai_giang;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWrite {
    public static void main(String[] args) {
        try{
            FileWriter writer = new FileWriter(".\\src\\bai16_io_text_file\\bai_giang\\hello.txt");
            writer.write("EM chào ");
            writer.write("Đại ca");
            writer.close(); // để chạy chương trình write
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
