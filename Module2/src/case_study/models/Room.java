package case_study.models;

public class Room extends Service {
    private ExtraService extraService;

    public Room() {
    }

    public Room(String[] list) {
        this.id = list[0];
        this.serviceName = list[1];
        this.area = Double.parseDouble(list[2]);
        this.price = Integer.parseInt(list[3]);
        this.capacity = Integer.parseInt(list[4]);
        this.rentType = list[5];
        this.extraService = new ExtraService(list[6],list[7],Double.parseDouble(list[8]));
    }

    public Room(String id, String serviceName, double area, int price, int capacity, String rentType, ExtraService extraService) {
        super(id, serviceName, area, price, capacity, rentType);
        this.extraService = extraService;
    }

    @Override
    public String toString() {
        return id +
                "," + serviceName +
                "," + area +
                "," + price +
                "," + capacity +
                "," + rentType +
                "," + extraService.toString() ;
    }

    @Override
    public void showInfo() {
        System.out.println("Room{" +
                "id='" + id + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", area=" + area +
                ", price=" + price +
                ", capacity=" + capacity +
                ", rentType=" + rentType +
                '}');
        extraService.showInfo();
    }

    public ExtraService getFreeService() {
        return extraService;
    }

    public void setFreeService(ExtraService freeService) {
        this.extraService = freeService;
    }


}
