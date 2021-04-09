package bai10_dsa_list.thuc_hanh.simple_linked_list;

import java.util.Arrays;
import java.util.function.DoubleToIntFunction;

public class TestMyLinkedList {
    public static void main(String[] args) {
        System.out.println(">>>>>>>> TESTING <<<<<<<<<<");
        MyLinkedList l1 = new MyLinkedList(10);
        l1.addFirst(Arrays.toString(new int[]{11, 2}));
        l1.addFirst(12);
        l1.addFirst(13);
        l1.add(4,9);
        l1.add(4,10);

        l1.add(1,2); l1.printList();
        System.out.println();

        System.out.println("get : " +l1.get(1));
    }
}
