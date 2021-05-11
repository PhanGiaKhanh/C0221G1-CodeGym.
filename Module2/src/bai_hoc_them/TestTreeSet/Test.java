package bai_hoc_them.TestTreeSet;

import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("Hai");
        Person p2 = new Person("Anh");
        Person p3 = new Person("Hanh");
        Person p4 = new Person("Bong");
        Set treeSet = new TreeSet();
        treeSet.add(p1);
        treeSet.add(p2);
        treeSet.add(p3);
        treeSet.add(p4);

        System.out.println(treeSet);
        System.out.println();
        treeSet.forEach(e-> System.out.println(e));
        System.out.println();
        for (Object p : treeSet){
            System.out.println(p);
            System.out.println(p.toString()); System.out.println();
        }
    }
}
