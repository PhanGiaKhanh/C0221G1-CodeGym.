package bai11_dsa_stack_queue.bai_tap;

import java.util.*;

public class DemergingData {
    public static void main(String[] args) {
        Queue<Person> female = new LinkedList<>();
        Queue<Person> male = new LinkedList<>();
        Person[] persons = new Person[5];
        persons[0] = new Person("Lê Thị D", "Male", 24);
        persons[1] = new Person("Trần Thị A", "Male", 20);
        persons[2] = new Person("Đoàn Văn D", "Female", 20);
        persons[3] = new Person("Là Thị d", "Female", 24);
        persons[4] = new Person("Tao Văn A", "Male", 20);
        Comparator<Person> comparator = (o1, o2) -> {
            if (o1.getAge() > o2.getAge())return 1;
            else if(o1.getAge() == o2.getAge()){
                return o1.getName().compareTo(o2.getName());
//                return  0;
            }
            else return -1;
        };
//        Comparator<Person> comparator = new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                if (o1.getAge() > o2.getAge()) return 1;
//                else if (o1.getAge() < o2.getAge()) return -1;
//                else return 0;
//            }
//        };
        Arrays.sort(persons, comparator);
        for (Person person : persons) {
            System.out.println(person.toString());
        }
        for (Person person : persons) {
            if (person.getGender().equals("Male")) {
                male.add(person);
            }
            if (person.getGender().equals("Female")) {
                female.add(person);
            }
        }
        Stack<Person> output = new Stack<>();
        while (!female.isEmpty()) {
            output.push(female.remove());
        }
        while (!male.isEmpty()) {
            output.push(male.remove());
        }
        System.out.println();
        for (Person person : output){
            System.out.println(person.toString());
        }
    }

    public static class Person {
        private String name;
        private int age;
        private String gender;

        public Person(String name, String gender, int age) {
            this.name = name;
            this.gender = gender;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    '}';
        }
    }
}
