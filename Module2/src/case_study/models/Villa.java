package case_study.models;

public class Villa extends Service {
    private String standard; //tiêu chuẩn
    private String convenient; // tiện  nghi
    private int floors;
    private double poolArea; // diện tích hồ bơi

    public Villa() {
    }
    public Villa(String[] list) {
        this.id = list[0];
        this.serviceName = list[1];
        this.area = Double.parseDouble(list[2]);
        this.price = Integer.parseInt(list[3]);
        this.capacity = Integer.parseInt(list[4]);
        this.rentType = list[5];
        this.standard = list[6];
        this.convenient = list[7];
        this.floors = Integer.parseInt(list[8]);
        this.poolArea = Double.parseDouble(list[9]);
    }

    public Villa(String id, String serviceName, double area, int price, int capacity, String rentType, String standard, String convenient, int floors, double poolArea) {
        super(id, serviceName, area, price, capacity, rentType);
        this.standard = standard;
        this.convenient = convenient;
        this.floors = floors;
        this.poolArea = poolArea;
    }

    @Override
    public String toString() {
        return id + '\'' +
                "," + serviceName +
                "," + area +
                "," + price +
                "," + capacity +
                "," + rentType +
                "," + standard +
                "," + convenient +
                "," + floors +
                "," + poolArea;
    }

    @Override
    public void showInfo() {
        System.out.println("Villa{" +
                ", id='" + id + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", area=" + area +
                ", price=" + price +
                ", capacity=" + capacity +
                ", rentType='" + rentType + '\'' +
                ", standard='" + standard + '\'' +
                ", convenient='" + convenient + '\'' +
                ", floors=" + floors +
                ", poolArea=" + poolArea +
                '}');
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
}
