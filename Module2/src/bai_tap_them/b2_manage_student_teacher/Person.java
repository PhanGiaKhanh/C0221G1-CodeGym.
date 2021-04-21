package bai_tap_them.b2_manage_student_teacher;

import java.util.Scanner;

public class Person {
    private String name;
    private String gender;
    private String birthday;
    private String address;
    public Person(){}
    public Person(String name, String gender, String birthday, String address) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
    }
    public void inputInfo(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input name: ");
        name = scanner.nextLine();
        System.out.print("Input gender: ");
        gender = scanner.nextLine();
        System.out.print("Input birthday: ");
        birthday = scanner.nextLine();
        System.out.print("Input address: ");
        address = scanner.nextLine();
    }

    public void showInfo(){
        System.out.println("{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                '}');
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
