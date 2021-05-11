package bai_hoc_them.TestTreeSet;

public class Person implements Comparable<Person> {
    private String ten;

    public Person(String ten) {
        this.ten = ten;
    }

    @Override
    public String toString() {
        return ten;
    }

    @Override
    public int compareTo(Person o) {
        return this.ten.compareTo(o.ten);
    }
}
