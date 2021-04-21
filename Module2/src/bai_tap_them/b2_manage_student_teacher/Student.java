package bai_tap_them.b2_manage_student_teacher;

import java.util.Scanner;

public class Student extends Person {
    private int studentCode;
    private double mediumScore;
    private String email;
    public void studentship(){
        if (mediumScore > 8){
            System.out.println(super.getName() + "has Studentship");
        }else {
            System.out.println(super.getName() + "has not studentship");
        }
    }

    public int getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(int studentCode) {
        this.studentCode = studentCode;
    }

    public double getMediumScore() {
        return mediumScore;
    }

    public void setMediumScore(double mediumScore) {
        this.mediumScore = mediumScore;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentCode=" + studentCode +
                ", mediumScore=" + mediumScore +
                ", email='" + email + '\'' +
                '}' + super.toString();
    }

    @Override
    public void inputInfo() {
        Scanner scanner = new Scanner(System.in);
        super.inputInfo();
        System.out.print("Input Student Code: ");
        studentCode = Integer.parseInt(scanner.nextLine());
        System.out.print("Input Medium Score: ");
        mediumScore = Double.parseDouble(scanner.nextLine());
        System.out.print("Input Email: ");
        email = scanner.nextLine();
        System.out.println();
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Student code: " + studentCode + "" +
                "\nMedium score: " + mediumScore + "" +
                "\nEmail : " + email);
        System.out.println();
    }
}
