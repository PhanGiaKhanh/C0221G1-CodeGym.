package model.bean;

public class Employee {
    private  int id;
    private String emCode;
    private String emName;
    private String birthday;

    public Employee() {
    }

    public Employee(String emCode, String emName, String birthday) {
        this.emCode = emCode;
        this.emName = emName;
        this.birthday = birthday;
    }

    public Employee(int id, String emCode, String emName, String birthday) {
        this.id = id;
        this.emCode = emCode;
        this.emName = emName;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmCode() {
        return emCode;
    }

    public void setEmCode(String emCode) {
        this.emCode = emCode;
    }

    public String getEmName() {
        return emName;
    }

    public void setEmName(String emName) {
        this.emName = emName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
