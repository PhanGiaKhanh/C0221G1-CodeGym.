package case_study;

public abstract class Service {
    private String id;
    private String nameService;
    private double area;
    private int price;
    private int capacity;
    private int rentType;

    public Service(String id, String nameService, double area, int price, int capacity, int rentType) {
        this.id = id;
        this.nameService = nameService;
        this.area = area;
        this.price =price;
        this.capacity = capacity;
        this.rentType = rentType;
    }

    public abstract void showInfor();
}
