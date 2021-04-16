package case_study.models;

public class Villa extends Service {
    private String standard; //tiêu chuẩn
    private String convenient; // tiện  nghi
    private int floors;
    private double poolArea; // diện tích hồ bơi

    public Villa() {
    }

    @Override
    public String showInfor() {
        return super.toString()
                + "\nStandard: " + standard
                + "\nComfort: " + convenient
                + "\nFloors: " + floors
                + "\nPool Area: " + poolArea;
    }

    public Villa(String standard, String convenient, int floors, double poolArea) {
        this.standard = standard;
        this.convenient = convenient;
        this.floors = floors;
        this.poolArea = poolArea;
    }

    public Villa(String id, String serviceName, double area, int price, int capacity, int rentType, String standard, String convenient, int floors, double poolArea) {
        super(id, serviceName, area, price, capacity, rentType);
        this.standard = standard;
        this.convenient = convenient;
        this.floors = floors;
        this.poolArea = poolArea;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getConvenient() {
        return convenient;
    }

    public void setConvenient(String convenient) {
        this.convenient = convenient;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "standard=" + standard +
                ", comfort='" + convenient + '\'' +
                ", floors=" + floors +
                ", poolArea=" + poolArea +
                '}';
    }
}
