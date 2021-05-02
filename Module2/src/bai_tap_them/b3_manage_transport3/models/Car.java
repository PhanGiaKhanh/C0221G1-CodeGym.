package bai_tap_them.b3_manage_transport3.models;

public class Car extends Vehicle{
    private int numberOfSeat;
    private String typeCar;

    public Car() {
    }

    public Car(String[] strings) {
        this.numberPlate = strings[0];
        this.manufacturerName = strings[1];
        this.yearOfManufacturer = Integer.parseInt(strings[2]);
        this.owner = strings[3];
        this.numberOfSeat = Integer.parseInt(strings[4]);
        this.typeCar = strings[5];
    }

    public Car(String numberPlate, String manufacturerName, int yearOfManufacturer, String owner, int numberOfSeat, String typeCar) {
        super(numberPlate, manufacturerName, yearOfManufacturer, owner);
        this.numberOfSeat = numberOfSeat;
        this.typeCar = typeCar;
    }

    @Override
    public String toString() {
        return numberPlate +
                "," + manufacturerName +
                "," + yearOfManufacturer +
                "," + owner +
                "," + numberOfSeat +
                "," + typeCar;
    }

    @Override
    public void showInfo() {
        System.out.println("Car{" +
                "numberPlate='" + numberPlate + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", yearOfManufacturer=" + yearOfManufacturer +
                ", owner='" + owner + '\'' +
                ", numberOfSeat=" + numberOfSeat +
                ", typeCar='" + typeCar + '\'' +
                '}');
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }
}
