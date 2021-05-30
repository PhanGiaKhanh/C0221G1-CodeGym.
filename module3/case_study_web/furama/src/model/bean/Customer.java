package model.bean;

public class Customer {
//    Họ tên Customer (customer_name), Ngày sinh (customer_birthday),
//    Giới tính (customer_gender), Số CMND (customer_id_card),
//    Số Điện Thoại (customer_phone), Email (customer_email),
//    Loại khách (customer_type_id), Địa chỉ (customer_address)
    private int id;
    private String c_name;
    private String c_birthday;
    private String c_gender;
    private int c_id_card;
    private String c_phone;
    private String c_email;
    private String c_type;
    private String c_address;

    public Customer() {
    }

    public Customer(int id, String c_name, String c_birthday, String c_gender, int c_id_card, String c_phone, String c_email, String c_type, String c_address) {
        this.id = id;
        this.c_name = c_name;
        this.c_birthday = c_birthday;
        this.c_gender = c_gender;
        this.c_id_card = c_id_card;
        this.c_phone = c_phone;
        this.c_email = c_email;
        this.c_type = c_type;
        this.c_address = c_address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_birthday() {
        return c_birthday;
    }

    public void setC_birthday(String c_birthday) {
        this.c_birthday = c_birthday;
    }

    public String getC_gender() {
        return c_gender;
    }

    public void setC_gender(String c_gender) {
        this.c_gender = c_gender;
    }

    public int getC_id_card() {
        return c_id_card;
    }

    public void setC_id_card(int c_id_card) {
        this.c_id_card = c_id_card;
    }

    public String getC_phone() {
        return c_phone;
    }

    public void setC_phone(String c_phone) {
        this.c_phone = c_phone;
    }

    public String getC_email() {
        return c_email;
    }

    public void setC_email(String c_email) {
        this.c_email = c_email;
    }

    public String getC_type() {
        return c_type;
    }

    public void setC_type(String c_type) {
        this.c_type = c_type;
    }

    public String getC_address() {
        return c_address;
    }

    public void setC_address(String c_address) {
        this.c_address = c_address;
    }
}
