package case_study;

public class Villa extends House {
//    private byte standard; //tiêu chuẩn
//    private String comfort; // tiện  nghi
//    private int floors;
    private double poolArea; // diện tích hồ bơi

    public Villa(String id, String nameService, double area,
                 int price, int capacity, int rentType,
                 byte standard, String comfort, int floors,
                 double poolArea) {
        super(id, nameService, area,
                price, capacity, rentType,
                standard, comfort, floors);
        this.poolArea = poolArea;
    }
}
