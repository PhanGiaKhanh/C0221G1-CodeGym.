package case_study;

public class House extends Service{
    private byte standard; //tiêu chuẩn
    private String comfort; // tiện nghi
    private int floors;

    public House (String id, String nameService, double area,
                  int price, int capacity, int rentType,
                  byte standard, String comfort, int floors){
        super(id, nameService, area,price,capacity,rentType);
        this.standard = standard;
        this.comfort = comfort;
        this.floors = floors;
    }
    @Override
    public void showInfor() {

    }
}
