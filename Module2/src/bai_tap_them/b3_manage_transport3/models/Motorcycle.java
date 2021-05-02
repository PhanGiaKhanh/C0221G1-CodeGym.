package bai_tap_them.b3_manage_transport3.models;

public class Motorcycle extends Vehicle {
    private int wattage;

    public Motorcycle() {
    }

    public Motorcycle(String[] strings) {
        this.numberPlate = strings[0];
        this.manufacturerName = strings[1];
        this.yearOfManufacturer = Integer.parseInt(strings[2]);
        this.owner = strings[3];
        this.wattage = Integer.parseInt(strings[4]);
    }

    public Motorcycle(String numberPlate, String manufacturerName, int yearOfManufacturer, String owner, int wattage) {
        super(numberPlate, manufacturerName, yearOfManufacturer, owner);
        this.wattage = wattage;
    }

    @Override
    public String toString() {
        return numberPlate +
                "," + manufacturerName +
                "," + yearOfManufacturer +
                "," + owner +
                "," + wattage;
    }

    @Override
    public void showInfo() {
        System.out.println("Motorcycle{" +
                "numberPlate='" + numberPlate + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", yearOfManufacturer=" + yearOfManufacturer +
                ", owner='" + owner + '\'' +
                ", wattage=" + wattage +
                '}');
    }

    public int getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }
}
