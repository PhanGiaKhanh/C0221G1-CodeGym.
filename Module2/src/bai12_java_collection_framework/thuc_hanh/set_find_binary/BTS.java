package bai12_java_collection_framework.thuc_hanh.set_find_binary;

public class BTS<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BTS() {
    }

    public BTS(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            insert(objects[i]);
        }
    }

    @Override
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e); /*create a new root*/
        else {
            /*locate the parent node*/
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false; /*Duplicate node not inserted*/
            }
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true; /*element inserted successfully*/
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) {
            inorder(root.left);
            System.out.println(root.element + " ");
            inorder(root.right);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    protected void postOrder(TreeNode<E> root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.element);
        }
    }
    @Override
    public void postOrder1() {
        postOrder(root);
    }

    protected void postOrder1(TreeNode<E> root) {
        if (root != null) {
            System.out.println(root.element);
            postOrder(root.left);
            postOrder(root.right);
        }
    }

    public void deleteKey(E key) {
        root = deleteRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
    protected TreeNode<E> deleteRec(TreeNode<E> root, E key) {
        /* Base Case: If the tree is empty */
        if (root == null) return root;

        /* Otherwise, recur down the tree */
        if (key.compareTo(root.element) < 0)
            root.left = deleteRec(root.left, key);
        else if (key.compareTo(root.element) > 0)
            root.right = deleteRec(root.right, key);

            // if key is same as root's key, then This is the node
            // to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.element = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.element);
        }

        return root;
    }

    protected E minValue(TreeNode<E> root) {
        E minv = root.element;
        while (root.left != null) {
            minv = root.left.element;
            root = root.left;
        }
        return minv;
    }

    protected boolean Search(E key) {
        TreeNode<E> current = root;
        while (current.left !=null){
            if (key.compareTo(current.element)>0) current.left = current;
            else if (key.compareTo(current.element)<0) current.right = current;
            else {
                if (current.element.compareTo(key)==0){
                    return true;
                }
                if (current == null){
                    System.out.println("không tìm thấy");
                    return false;
                }

            }
        }
        return false;
    }
}
