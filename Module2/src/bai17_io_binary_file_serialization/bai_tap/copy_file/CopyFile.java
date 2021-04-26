package bai17_io_binary_file_serialization.bai_tap.copy_file;

import bai17_io_binary_file_serialization.bai_tap.manage_product.Product;

import java.io.*;
import java.util.List;

public class CopyFile {
    public static void copyFile(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            is.close();
            os.close();
        }
    }
    public static void readFile(String path) {
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Product> listProduct = (List<Product>) ois.readObject();
            System.out.println(listProduct);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String path1 = "src/bai17_io_binary_file_serialization/bai_tap/manage_product/list.txt";
        String path2 = "src/bai17_io_binary_file_serialization/bai_tap/copy_file/copyFile.txt";
        File sourceFile = new File(path1);
        File destFile = new File(path2);
        try {
            copyFile(sourceFile,destFile);
        }catch (IOException e){
            System.out.println("loi " + e);
        }
        readFile(path2);
    }
}
