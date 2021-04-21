package bai_tap_them.b2_manage_student_teacher;

import java.util.*;

public class StudentTest {
    public static void main(String[] args) {
        byte choose;
        int size;
        Scanner scanner = new Scanner(System.in);
        List<Student> listStudent = new ArrayList<>();
        do {
            System.out.println("1. Input n student" +
                    "\n2. Display students" +
                    "\n3. Display student has min/max medium score" +
                    "\n4. Search student by student code" +
                    "\n5. Display student by sort name" +
                    "\n6. Display student(studentship) + sort" +
                    "\n7. Exit");
            choose = Byte.parseByte(scanner.nextLine());
            chooseMethod(choose, scanner, listStudent);
        } while (choose != 7);
    }

    private static void chooseMethod(byte choose, Scanner scanner, List<Student> listStudent) {
        switch (choose) {
            case 1:
                addStudents(scanner, listStudent);break;
            case 2:
                displayListStudent(listStudent);break;
            case 3:
                minMaxStudentScore(listStudent);break;
            case 4:
                searchStudentByCode(scanner, listStudent);break;
            case 5:
                displayStudentSortName(listStudent);break;
            case 6:
                displayStudentByScore(listStudent);break;
            default:
                break;
        }
    }

    private static void displayStudentByScore(List<Student> listStudent) {
        List<Student> temp = listStudent;
        temp.sort(Comparator.comparing(Student::getMediumScore).reversed());
        temp.forEach(student -> student.showInfo());
    }

    private static void searchStudentByCode(Scanner scanner, List<Student> listStudent) {
        System.out.print("Input student code: ");
        int inputStudentCode = Integer.parseInt(scanner.nextLine());
        for (Student student : listStudent) {
            if (student.getStudentCode() == inputStudentCode) {
                System.out.println("Student you search: ");
                student.showInfo();
                return;
            }
        }
        System.out.println("Not exist student with:  " + inputStudentCode);
    }

    private static void displayStudentSortName(List<Student> listStudent) {
        System.out.println("------------Display student sort name A > Z ------------");
        List<Student> temp = listStudent;
        temp.sort(Comparator.comparing(Student::getName));
        temp.forEach(student -> student.showInfo());
    }

    private static void minMaxStudentScore(List<Student> listStudent) {
        System.out.println("-----------Display student by Score decrease-----------");
        double max = listStudent.get(0).getMediumScore();
        Student studentMax = listStudent.get(0);
        double min = listStudent.get(0).getMediumScore();
        Student studentMin = listStudent.get(0);
        for (Student student : listStudent) {
            if (max < student.getMediumScore()){
                max = student.getMediumScore();
                studentMax = student;
            }
            if (min > student.getMediumScore()){
                min = student.getMediumScore();
                studentMin = student;
            }
        }
//        System.out.println("Student has max medium score: " + studentMax);
        studentMax.showInfo();
//        System.out.println("Student has min medium score: " + studentMin);
        studentMin.showInfo();
    }

    private static void displayListStudent(List<Student> listStudent) {
//        listStudent.forEach(student -> student.showInfo());
        System.out.println("---------------------Display list Student ---------------------");
        int count = 0;
        for (Student student : listStudent){
            count++;
            System.out.println("----------Student " + count +"----------");
            student.showInfo();
        }
    }

    private static void addStudents(Scanner scanner, List<Student> listStudent) {
        int size;
        System.out.print("Number of students is: ");
        size = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < size; i++) {
            Student student = new Student();
            System.out.println("----------Student " + (i+1) +"----------");
            student.inputInfo();
            listStudent.add(student);
        }
    }
}
