package bai10_dsa_list.bai_tap.implementing_method_linkedlist;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }

    public MyLinkedList() {
        head = new Node("");
    }

    public MyLinkedList(Object data) {
        head = new Node(data);
    }

    public void add(int index, String element) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(E element) {
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E element) {
        Node temp = head;
        for (int i = 0; temp.next != null; i++) {
            temp = temp.next;
        }
        temp.next = new Node(element);
//        head.next = new Node(element);
        numNodes++;
    }



    public Object get1(int index) {
        if (index >= numNodes || index <= 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println((E) temp.data);
            temp = temp.next;
        }
    }

    public E remove(int index) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 2 && temp.next != null; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return (E) temp;
    }

    public boolean remove(Object e) {
        Node temp = head;
        Node holder;
        boolean result = false;
        for (int i = 0; temp != null; i++) {
            if (temp.next.data == e) {
                result = true;
                break;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return result;
    }
    public int size() {
        Node temp = head;
        int count =0;
        for (int i = 0; temp.next != null; i++) {
            temp = temp.next;
            count++;
        }
        return count;
    }
    public E clone(){
        return (E) this;
    }
    public boolean contains(E o){
        Node temp = head;
        boolean result = false;
        for (int i = 0; temp.next != null; i++) {
            if (temp.data == o){
                result = true;
                break;
            }
            temp = temp.next;
        }
        return result;
    }
    public int indexOf(E o){
        Node temp = head;
        int index = -1;
        for (int i = 0; temp.next != null ; i++) {
            if (temp.data == o){
                index = i;
                break;
            }
            temp = temp.next;
        }
        return index;
    }
//    public void ensureCapacity(int minCapacity){
//
//    }
    public E get(int index){
        Node temp = head;
        E result = null;
        for (int i = 0; temp.next != null; i++) {
            if (i == index-1){
                result = (E) temp;
            }
            temp= temp.next;
        }
        return result;
    }
    //    public E get(int index) {
//        Node temp = head;
//        for (int i = 0; i < index - 1; i++) {
//            temp = temp.next;
//        }
//        return (E) temp;
//    }
    public E getFist(){
        return (E) head;
    }
    public E getLast(){
        Node temp =head;
        for (int i = 0; temp.next != null; i++) {
            temp = temp.next;
        }
        return (E)temp;
    }
}