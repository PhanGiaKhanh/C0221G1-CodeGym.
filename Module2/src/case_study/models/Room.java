package case_study.models;

public class Room extends Service {
    private String freeService;

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }
    public Room(String id, String serviceName, double area, int price, int capacity, int rentType ,String freeService){
        super(id, serviceName, area, price, capacity, rentType);
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeService='" + freeService + '\'' +
                '}';
    }

    @Override
    public String showInfor() {
        return super.toString()
                + "\nFree Service: " + freeService;
    }

}
