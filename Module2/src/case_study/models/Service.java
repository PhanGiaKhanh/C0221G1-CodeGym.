package case_study.models;

public abstract class Service {
    protected String id;
    protected String serviceName;
    protected double area;
    protected int price;
    protected int capacity;
    protected String rentType;

    public Service() {
    }

    public Service(String id, String serviceName, double area, int price, int capacity, String rentType) {
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

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
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

    public abstract void showInfo();
}
