package case_study.models;

public class House extends Service {
    private String standard; //tiêu chuẩn
    private String convenient; // tiện nghi
    private int floors;

    public House() {
    }

    @Override
    public String showInfor() {
        return super.toString()
                + "\nStandard: " + standard
                + "\nComfort: " + convenient
                + "\nFloors: " + floors;
    }

    public House(String standard, String convenient, int floors) {
        this.standard = standard;
        this.convenient = convenient;
        this.floors = floors;
    }

    public House(String id, String nameService, double area,
                 int price, int capacity, int rentType,
                 String standard, String convenient, int floors) {
        super(id, nameService, area, price, capacity, rentType);
        this.standard = standard;
        this.convenient = convenient;
        this.floors = floors;
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
