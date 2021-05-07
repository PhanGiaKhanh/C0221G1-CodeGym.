package bai_hoc_them.compare.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Kien", 30, "HT");
        Student student1 = new Student("Nam", 26, "HN");
        Student student2 = new Student("Anh", 38, "HT" );
        Student student3 = new Student("Tung", 38, "HT" );
        Student student4 = new Student("Tung", 30, "HT" );

        List<Student> lists = new ArrayList<Student>();
        lists.add(student);
        lists.add(student1);
        lists.add(student2);
        lists.add(student3);
        lists.add(student4);
        Collections.sort(lists);
        for(Student st : lists){
            System.out.println(st.toString());
        }
        System.out.println();
        Student student9 = new Student();
        Collections.sort(lists, student9);
        lists.forEach(e-> System.out.println(e));
    }
}
