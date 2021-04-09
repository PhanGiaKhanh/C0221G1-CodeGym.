package bai10_dsa_list.bai_tap.implementing_method_linkedlist;

import java.util.Arrays;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> lists = new MyLinkedList<>(10);
        lists.add(1, Arrays.toString(new int[]{1, 2}));
        lists.addFirst(3);
        lists.addFirst(6);
        lists.addFirst(4);
        lists.addLast(20);

        lists.printList();
        lists.remove((Object)6);
        System.out.println();
        lists.printList();
        System.out.println();
        System.out.println(lists.contains(2));
        System.out.println(lists.indexOf(4));
        System.out.println(lists.get(2));
//        System.out.println("\n"+lists.get1(1));
//        System.out.println("\n"+lists.get1(4));
    }
}
