package case_study.commons;

import bai_tap_them.b3_manage_transport3.models.Car;
import bai_tap_them.b3_manage_transport3.models.Motorcycle;
import bai_tap_them.b3_manage_transport3.models.Truck;
import bai_tap_them.b3_manage_transport3.models.Vehicle;
import case_study.models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static final String PATH = "src/case_study/data/";

    public static void write(String fileName, List<Service> lists, boolean append){
        String path = PATH + fileName;
        FileWriter fileWriter = null;
        BufferedWriter bw = null;
        try{
            fileWriter = new FileWriter(path,append);
            bw = new BufferedWriter(fileWriter);
            for (Service list : lists){
                bw.write(list.toString());
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                fileWriter.close();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void writeString(String fileName, String string, boolean append){
        String path = PATH + fileName;
        FileWriter fileWriter = null;
        BufferedWriter bw = null;
        try{
            fileWriter = new FileWriter(path,append);
            bw = new BufferedWriter(fileWriter);

                bw.write(string);
                bw.newLine();

            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                fileWriter.close();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
      public static List<Service> read(String fileName) {
        String path = fileName;
        File file = null;
        List<Service> list = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader br = null;
        String line = null;
        String[] strings = null;
        try {
            file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            fileReader = new FileReader(path);
            br = new BufferedReader(fileReader);
            while ((line = br.readLine()) != null) {
                strings = line.split(",");
                if (strings.length == 9 && strings[0].contains("RO")) {
                    Service room = new Room(strings);
                    list.add(room);
                } else if (strings.length == 9 &&  strings[0].contains("HO")) {
                    Service house = new House(strings);
                    list.add(house);
                } else if (strings.length == 10) {
                    Service villa = new Villa(strings);
                    list.add(villa);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                br.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    public static List<Customer> readCustomer(String fileName) {
        String path = PATH + fileName;
        List<Customer> list = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader br = null;
        String line = null;
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            fileReader = new FileReader(path);
            br = new BufferedReader(fileReader);
            Customer customer;
            while ((line = br.readLine()) != null) {
                customer = new Customer(line.split(","));
                list.add(customer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
