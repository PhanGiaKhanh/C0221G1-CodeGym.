package bai_tap_them.b3_manage_transport3.commons;

import bai_tap_them.b3_manage_transport3.models.Car;
import bai_tap_them.b3_manage_transport3.models.Motorcycle;
import bai_tap_them.b3_manage_transport3.models.Truck;
import bai_tap_them.b3_manage_transport3.models.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static final String PATH = "src/bai_tap_them/b3_manage_transport3/data/";

    public static void write(String fileName, List<Vehicle> vehicles, boolean status) {
        String path = PATH + fileName;
        FileWriter fileWriter = null;
        BufferedWriter bw = null;
        try {
            fileWriter = new FileWriter(path, status);
            bw = new BufferedWriter(fileWriter);
            for (Vehicle vehicle : vehicles) {
                bw.write(vehicle.toString());
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fileWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Vehicle> read(String fileName) {
        String path = PATH + fileName;
        File file = null;
        List<Vehicle> list = new ArrayList<>();
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
                if (strings.length == 6) {
                    Vehicle car = new Car(strings);
                    list.add(car);
                } else if (strings.length == 5 && strings[0].contains("C")) {
                    Vehicle truck = new Truck(strings);
                    list.add(truck);
                } else if (strings.length == 5 && !strings[0].contains("C")) {
                    Vehicle motorcycle = new Motorcycle(strings);
                    list.add(motorcycle);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
    public static List<String> readManufacturer(String fileName) {
        String path = PATH + fileName;
        List<String> list = new ArrayList<>();
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
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
}