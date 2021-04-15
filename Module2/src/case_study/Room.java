package case_study;

public class Room extends Service{
    private String serviceFree;

    public Room(String id, String nameService, double area, int price, int capacity, int rentType) {
        super(id, nameService, area, price, capacity, rentType);
    }

    @Override
    public void showInfor() {

    }
}
