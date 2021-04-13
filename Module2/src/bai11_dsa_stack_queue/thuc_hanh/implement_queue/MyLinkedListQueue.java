package bai11_dsa_stack_queue.thuc_hanh.implement_queue;

import bai10_dsa_list.thuc_hanh.simple_linked_list.MyLinkedList;

public class MyLinkedListQueue {
    private Node head;
    private Node tail;

    public MyLinkedListQueue() {
        head = null;
        tail = null;
    }

    public void enqueue(int key) {
        Node temp = new Node(key);
        if (tail == null){
            head =tail = temp;
            return;
        }
        tail.next = temp;
        tail = temp;
    }
    public Node dequeue(){
        if (head == null){
            return null;
        }
        Node temp = head;
        head = head.next;
        if (head == null){
            tail = null;
        }
        return temp;
    }
}
