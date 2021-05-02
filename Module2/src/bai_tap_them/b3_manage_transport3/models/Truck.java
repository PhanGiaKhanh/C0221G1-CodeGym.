package bai_tap_them.b3_manage_transport3.models;

public class Truck extends Vehicle {
    private double payLoad;

    public Truck() {
    }

    public Truck(String[] strings) {
        this.numberPlate = strings[0];
        this.manufacturerName = strings[1];
        this.yearOfManufacturer = Integer.parseInt(strings[2]);
        this.owner = strings[3];
        this.payLoad = Double.parseDouble(strings[4]);
    }

    public Truck(String numberPlate, String manufacturerName, int yearOfManufacturer, String owner, double payLoad) {
        super(numberPlate, manufacturerName, yearOfManufacturer, owner);
        this.payLoad = payLoad;
    }

    @Override
    public String toString() {
        return numberPlate +
                "," + manufacturerName +
                "," + yearOfManufacturer +
                "," + owner +
                "," + payLoad;
    }

    @Override
    public void showInfo() {
        System.out.println("Truck{" +
                "numberPlate='" + numberPlate + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", yearOfManufacturer=" + yearOfManufacturer +
                ", owner='" + owner + '\'' +
                ", payLoad=" + payLoad +
                '}');
    }

    public double getPayLoad() {
        return payLoad;
    }

    public void setPayLoad(double payLoad) {
        this.payLoad = payLoad;
    }
}
