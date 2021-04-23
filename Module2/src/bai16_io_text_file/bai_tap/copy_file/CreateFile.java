package bai16_io_text_file.bai_tap.copy_file;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) throws IOException {
        File f = new File("src\\bai16_io_text_file\\bai_tap\\copy_file\\file.txt");
        if(!f.exists()){
            f.createNewFile();
        }
    }
}
