package case_study.models;

public abstract class Service {
    private String id;
    private String serviceName;
    private double area;
    private int price;
    private int capacity;
    private int rentType;

    public Service() {
    }

    public Service(String id, String serviceName, double area, int price, int capacity, int rentType) {
        this.id = id;
        this.serviceName = serviceName;
        this.area = area;
        this.price = price;
        this.capacity = capacity;
        this.rentType = rentType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRentType() {
        return rentType;
    }

    public void setRentType(int rentType) {
        this.rentType = rentType;
    }

    @Override
    public String toString() {
        return "\nId= " + id +
                "\nnameService='" + serviceName +
                "\narea=" + area +
                "\nprice=" + price +
                "\ncapacity=" + capacity +
                "\nrentType=" + rentType;
    }

    public abstract String showInfor();
}
