package bai16_io_text_file.bai_giang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadATextFile {
    public static void main(String[] args) {
        try {
            File inFle = new File("Hello.txt");
            FileReader fileReader = new FileReader(inFle);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;
            while ((line = reader.readLine() )!= null) {
                System.out.println(line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String toSplit = "50,Zombie, teeth, hands";
        String[] results = toSplit.split(",");
        for (String token : results) {
            System.out.println(token);
        }
    }

}
