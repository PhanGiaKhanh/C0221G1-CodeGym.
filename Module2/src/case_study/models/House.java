package case_study.models;

public class House extends Service {
    private String standard; //tiêu chuẩn
    private String convenient; // tiện nghi
    private int floors;

    public House() {
    }
    public House(String[] list) {
        this.id = list[0];
        this.serviceName = list[1];
        this.area = Double.parseDouble(list[2]);
        this.price = Integer.parseInt(list[3]);
        this.capacity = Integer.parseInt(list[4]);
        this.rentType = list[5];
        this.standard = list[6];
        this.convenient = list[7];
        this.floors = Integer.parseInt(list[8]);
    }

    public House(String id, String nameService, double area,
                 int price, int capacity, String rentType,
                 String standard, String convenient, int floors) {
        super(id, nameService, area, price, capacity, rentType);
        this.standard = standard;
        this.convenient = convenient;
        this.floors = floors;
    }
    @Override
    public String toString() {
        return id +
                "," + serviceName +
                "," + area +
                "," + price +
                "," + capacity +
                "," + rentType +
                "," + standard +
                "," + convenient +
                "," + floors;
    }

    @Override
    public void showInfo() {
        System.out.println("House{" +
                "id='" + id + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", area=" + area +
                ", price=" + price +
                ", capacity=" + capacity +
                ", rentType=" + rentType +
                ", standard='" + standard + '\'' +
                ", convenient='" + convenient + '\'' +
                ", floors=" + floors +
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
}
