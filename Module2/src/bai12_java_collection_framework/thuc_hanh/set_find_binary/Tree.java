package bai12_java_collection_framework.thuc_hanh.set_find_binary;

public interface Tree<E> {
    boolean insert(E e);
    void inorder();
    int getSize();
    void postOrder();
}
