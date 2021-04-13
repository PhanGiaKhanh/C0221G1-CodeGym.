package bai12_java_collection_framework.bai_giang;

public class TreeNode<E> {
    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;

    public TreeNode(E e) {
        element = e;
    }

    public boolean search(TreeNode root, E element) {
        TreeNode<E> current = root;
//
//        while (current != null) {
//            if (element < current.element) {
//                current = current.left;
//            } else if (element > current.element) {
//                current = current.right;
//            } else
//                return true;
//        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(60);
        root.left = new TreeNode<>(55);
        root.right = new TreeNode<>(100);
        System.out.println(root.search(root, 55));
    }
}
