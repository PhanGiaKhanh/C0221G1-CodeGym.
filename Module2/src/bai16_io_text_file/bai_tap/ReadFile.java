package bai16_io_text_file.bai_tap;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {
//        File f = new File("src\\bai16_io_text_file\\bai_tap\\hello\\file.csv");
//        if (!f.exists()){
//            f.createNewFile();
//        }
        String path = "src\\bai16_io_text_file\\bai_tap\\hello\\file.csv";
        FileWriter fw = new FileWriter(path,true);

//        fw.append("\"1.0.0.0\",\"1.0.0.255\",\"16777216\",\"16777471\",\"AU\",\"Australia\"");
//        fw.append("\n");
//        fw.append("\"1.0.1.0\",\"1.0.3.255\",\"16777472\",\"16778239\",\"CN\",\"China\"");
        FileReader fr = new FileReader(path);
        int c = fr.read();
        while (c!=-1){
            System.out.print((char)c);

            c = fr.read();
        }
        fr.close();
    }
}
