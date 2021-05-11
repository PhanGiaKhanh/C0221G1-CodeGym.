package bai_hoc_them.TestReadFile;

public class Phone {
    private String n1;
    private String n2;
    private String n3;
    private String n4;
    private String n5;
    private String n6;
    private String n7;

    public Phone(String n1, String n2, String n3, String n4, String n5, String n6, String n7) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
        this.n5 = n5;
        this.n6 = n6;
        this.n7 = n7;
    }

    @Override
    public String toString() {
        return  n1 +
                "," + n2 +
                "," + n3 +
                "," + n4 +
                "," + n5 +
                "," + n6 +
                "," + n7;
    }
}
