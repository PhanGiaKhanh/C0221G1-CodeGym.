package bai_tap_them.b2_manage_student_teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherTest {
    public static void main(String[] args) {
        int choose;
        Scanner scanner = new Scanner(System.in);
        List<Teacher> teacherList = new ArrayList<>();
        do {
            System.out.println("Chọn 1: Nhập vào n giảng viên (n là số lượng sinh viên, được nhập từ bàn phím)\n" +
                    "\n" +
                    "Chọn 2: Hiển thị thông tin tất cả các giảng viên ra màn hình\n" +
                    "\n" +
                    "Chọn 3: Hiển thị giảng viên có lương cao nhất\n" +
                    "\n" +
                    "Chọn 4: Thoát");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    int size;
                    System.out.print("Number of teachers is: ");
                    size = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < size; i++) {
                        Teacher teacher = new Teacher();
                        System.out.println("----------Teacher " + (i + 1) + "----------");
                        teacher.inputInfo();
                        teacherList.add(teacher);
                    }
                case 2:
                    System.out.println("---------------------Display list Teacher ---------------------");
                    int count = 0;
                    for (Teacher teacher1 : teacherList){
                        count++;
                        System.out.println("----------Teacher " + count +"----------");
                        teacher1.showInfo();
                    }
                case 3:
                    System.out.println("------------Salary max -------------");
                    double salaryMax = teacherList.get(0).getSalary();
                    Teacher teacherSalaryMax = teacherList.get(0);
                    for (Teacher teacher : teacherList){
                        if (salaryMax < teacher.getSalary()){
                            teacherSalaryMax = teacher;
                            salaryMax = teacher.getSalary();
                        }
                    }
                    teacherSalaryMax.showInfo();
                    System.out.println("\n Salary : " + salaryMax);
                case 4:
                    break;
            }
        }while (choose != 4);
    }
}
