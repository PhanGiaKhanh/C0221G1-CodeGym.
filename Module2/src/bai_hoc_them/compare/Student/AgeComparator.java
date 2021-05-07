package bai_hoc_them.compare.Student;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {

    // không thể sử dụng được Comparable
//    @Override
//    public int compareTo(Student student) {
////        return this.getName().compareTo(student.getName());
//        if(this.getName().compareTo(student.getName())>0){
//            return 1;
//        }else if(this.getName().compareTo(student.getName())==0){
//            if (this.getAge() < student.getAge()) return -1;
//            if (this.getAge() > student.getAge()) return 1;
//            else return 0;
//        }else{
//            return -1;
//        }
//    }

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
//      không được
//    @Override
//    public int compareTo(Student o) {
//        return Student.getName().compareTo(o.getName());
//    }
}
