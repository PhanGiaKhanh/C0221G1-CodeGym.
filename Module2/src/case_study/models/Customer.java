package case_study.models;

public class Customer {
    private String customerName;
    private String dayOfBirth;
    private String gender;
    private String numberCMND;
    private String numberPhone;
    private String email;
    private String customerType;
    private String address;
    private Service service = null;

    public Customer() {
    }

    public Customer(String customerName, String dayOfBirth, String gender, String numberCMND, String numberPhone, String email, String customerType, String address) {
        this.customerName = customerName;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.numberCMND = numberCMND;
        this.numberPhone = numberPhone;
        this.email = email;
        this.customerType = customerType;
        this.address = address;
    }

    public Customer(String[] strings) {
        this.customerName = strings[0];
        this.dayOfBirth = strings[1];
        this.gender = strings[2];
        this.numberCMND = strings[3];
        this.numberPhone = strings[4];
        this.email = strings[5];
        this.customerType = strings[6];
        this.address = strings[7];
    }

    @Override
    public String toString() {
        return customerName +
                "," + dayOfBirth +
                "," + gender +
                "," + numberCMND +
                "," + numberPhone +
                "," + email +
                "," + customerType +
                "," + address;
    }
    public void showInfo(){
        System.out.println("Customer{" +
                "customerName='" + customerName + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", numberCMND='" + numberCMND + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", email='" + email + '\'' +
                ", customerType='" + customerType + '\'' +
                ", address='" + address + '\'' +
                '}');
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNumberCMND() {
        return numberCMND;
    }

    public void setNumberCMND(String numberCMND) {
        this.numberCMND = numberCMND;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
