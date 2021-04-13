package bai11_dsa_stack_queue.bai_tap.implement_queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.deQueue();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.deQueue();
        queue.displayQueue();
    }
}
