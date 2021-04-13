package bai11_dsa_stack_queue.thuc_hanh.optional_queue;

public class MyQueue {
    private int capacity;
    private int[] queueArr;
    private int head = 0;
    private int tail = -1;
    private int currentSize = 0;

    public MyQueue(int queueSize) {
        capacity = queueSize;
        queueArr = new int[capacity];
    }

    public boolean isQueueFull() {
        return currentSize == capacity ? true : false;
    }

    public boolean isQueueEmpty() {
        return currentSize == 0 ? true : false;
    }

    public void enqueue(int item){
        if (isQueueFull()){
            System.out.println("Overflow ! unable to add element: " + item);
        }else {
            tail++;
            if (tail == capacity - 1) {
                tail = 0;
            }
            queueArr[tail] = item;
            currentSize++;
            System.out.println("Element " + item + " is pushed to Queue !");
        }
    }
    public void dequeue(){
        if (isQueueEmpty()){
            System.out.println("Underflow ! Unable to remove element for Queue");
        }else {
            head++;
            if (head == capacity -1) {
                System.out.println("Pop operation done ! removed: " + queueArr[head - 1]);
                head = 0;
            }else {
                System.out.println("Pop operation done ! removed: " + queueArr[head - 1]);
            }
            currentSize--;
        }
    }
}
