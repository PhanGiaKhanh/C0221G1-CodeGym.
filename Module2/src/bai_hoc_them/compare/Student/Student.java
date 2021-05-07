package bai_hoc_them.compare.Student;

import java.util.Comparator;

public class Student implements Comparable<Student>, Comparator<Student> {
    private String name;
    private Integer age;
    private String address;

    public Student(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public static void hello(){
        System.out.println("hello");
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student student) {
//        return this.getName().compareTo(student.getName());
        if(this.getName().compareTo(student.getName())>0){
            return 1;
        }else if(this.getName().compareTo(student.getName())==0){
            if (this.getAge() < student.getAge()) return -1;
            if (this.getAge() > student.getAge()) return 1;
            else return 0;
        }else{
            return -1;
        }
    }

    @Override
    public int compare(Student o1, Student o2) {
        if((o1.getName().compareTo(o2.getName()))>0){
            return 1;
        }else if((o1.getName().compareTo(o2.getName()))==0){
            if (o1.getAge() < o2.getAge()) return -1;
            if (o1.getAge() > o2.getAge()) return 1;
            else return 0;
        }else{
            return -1;
        }
    }

    @Override
    public Comparator<Student> reversed() {
        return null;
    }
}
