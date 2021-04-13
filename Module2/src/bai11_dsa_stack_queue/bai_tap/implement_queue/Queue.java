package bai11_dsa_stack_queue.bai_tap.implement_queue;

public class Queue {
    private Node front;
    private Node rear;
    private int size = 0;
    public Queue(){
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return  front== null ? true : false;
    }

    public void enQueue(int data) {
        Node temp = new Node(data);
        if (isEmpty()) {
            front = rear = temp;
            return;
        }
        rear.link = temp;
        rear = temp;
        rear.link =front;
        size++;
    }

    public void deQueue() {
        if (isEmpty()) {
            return;
        }
        front = front.link;
        rear.link = front;
        size--;
    }

    public void displayQueue() {
        Node temp = front;
        int count = 0;
        while (count<=size){
            System.out.println(temp.data);
            temp = temp.link;
            count++;
        }
    }

}
