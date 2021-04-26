package bai17_io_binary_file_serialization.thuc_hanh.read_write_list_student;

import java.io.*;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectOutputStream;
//import java.io.Serializable;
import java.util.*;
//import java.util.ArrayList;
//import java.util.List;

public class Student implements Serializable {
    private int id;

    private String name;

    private String address;

    public Student() {
    }

    public Student(int id, String name, String address) {
        this.id = id;
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readDataFromFile(String path) {
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return students;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student VuKieuAnh = new Student(1, "Vũ Kiều Anh", "Hà Nội");
        Student NguyenMinhQuan = new Student(2, "Nguyễn Minh Quân", "Hà Nội");
        Student DangHuyHoa = new Student(3, "Đặng Huy Hoà", "Đà Nẵng");
        Student NguyenKhanhTung = new Student(4, "Nguyễn Khánh Tùng", "Hà Nội");
        Student NguyenKhacNhat = new Student(5, "Nguyễn Khắc Nhật", "Hà Nội");

        students.add(VuKieuAnh);
        students.add(NguyenKhanhTung);
        students.add(DangHuyHoa);
        students.add(NguyenMinhQuan);
        students.add(NguyenKhacNhat);
        String path = "src/bai17_io_binary_file_serialization/thuc_hanh/read_write_list_student/student.txt";
        writeToFile(path, students);
        List<Student> studentDataFromFile = readDataFromFile(path);
        for (Student student : studentDataFromFile) {
            System.out.println(student);
        }

    }
}
