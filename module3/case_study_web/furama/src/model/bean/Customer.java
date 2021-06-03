package model.bean;

public class Customer {
//    Họ tên Customer (customer_name), Ngày sinh (customer_birthday),
//    Giới tính (customer_gender), Số CMND (customer_id_card),
//    Số Điện Thoại (customer_phone), Email (customer_email),
//    Loại khách (customer_type_id), Địa chỉ (customer_address)
    private int id;
    private String name;
    private String birthday;
    private String gender;
    private String idCard;
    private String phone;
    private String email;
    private String type;
    private String address;

    public Customer() {
    }

    public Customer(String name, String birthday, String gender, String idCard, String phone, String email, String type, String address) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.type = type;
        this.address = address;
    }

    public Customer(int id, String name, String birthday, String gender, String idCard, String phone, String email, String type, String address) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.type = type;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
