package bai12_java_collection_framework.bai_tap;

import bai12_java_collection_framework.thuc_hanh.set_find_binary.BTS;

 public class DeleteBST {
    public static void main(String[] args) {

        BTS<String> tree1 = new BTS<>();
        tree1.insert("George");
        tree1.insert("Michael");
        tree1.insert("Tom");
        tree1.insert("Adam");
        tree1.insert("Jones");
        tree1.insert("Peter");
        tree1.insert("Daniel");
        System.out.println("Inorder (sorted): ");

//        tree.inorder();
        tree1.deleteKey("Jones");
        tree1.postOrder();

    }
}
