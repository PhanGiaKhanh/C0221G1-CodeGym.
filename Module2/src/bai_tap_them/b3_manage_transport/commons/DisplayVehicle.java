package bai_tap_them.b3_manage_transport.commons;

public class DisplayVehicle {
    public static void showCar(){
        System.out.println("Danh sách xe oto");
        for (String str : FileUtils.readFile()){
            String[] strings = str.split(",");

            if (strings.length==6){
                System.out.println(str);
            }
        }
    }
    public static void showMotobike(){
        System.out.println("Danh sách xe máy");
        for (String str : FileUtils.readFile()){
            String[] strings = str.split(",");

            if (strings.length==5 && strings[0].length()==12){
                System.out.println(str);
            }
        }
    }
    public static void showTruck(){
        System.out.println("Danh sách xe tải");
        for (String str : FileUtils.readFile()){
            String[] strings = str.split(",");

            if (strings.length==5 && strings[0].length()!=12){
                System.out.println(str);
            }
        }
    }
}
