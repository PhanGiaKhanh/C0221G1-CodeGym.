package bai_tap_them.b2_manage_student_teacher;

import java.util.Scanner;

public class Teacher extends Person{
    private String classOfTeach;
    private int salaryOneHour;
    private double hourTeaching;
    Scanner scanner = new Scanner(System.in);
    public Teacher(){}
    public Teacher(String classOfTeach, int salaryOneHour, double hourTeaching) {
        this.classOfTeach = classOfTeach;
        this.salaryOneHour = salaryOneHour;
        this.hourTeaching = hourTeaching;
    }

    public Teacher(String name, String gender, String birthday, String address, String classOfTeach, int salaryOneHour, double hourTeaching) {
        super(name, gender, birthday, address);
        this.classOfTeach = classOfTeach;
        this.salaryOneHour = salaryOneHour;
        this.hourTeaching = hourTeaching;
    }
    public double getSalary(){
        return salaryOneHour * hourTeaching;
    }
    @Override
    public void inputInfo() {
        super.inputInfo();
        System.out.print("Class : ");
        classOfTeach = scanner.nextLine();
        System.out.print("Salary 1 hour: ");
        salaryOneHour = Integer.parseInt(scanner.nextLine());
        System.out.print("Hour teaching: ");
        hourTeaching = Double.parseDouble(scanner.nextLine());
        System.out.println();
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Teacher{" +
                "classOfTeach='" + classOfTeach + '\'' +
                ", moneyOneHour=" + salaryOneHour +
                ", hourTeaching=" + hourTeaching +
                '}');

    }


}
