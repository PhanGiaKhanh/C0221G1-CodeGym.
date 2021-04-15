package bai12_java_collection_framework.bai_tap;

import bai12_java_collection_framework.thuc_hanh.set_find_binary.BTS;

public class TestSearchBST {
    public static void main(String[] args) {
        BTS<String> tree = new BTS<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");
        System.out.println("Inorder (sorted): ");
        tree.postOrder();
//        tree.inorder();
        System.out.println("The number of nodes is: " + tree.getSize());
    }
}
