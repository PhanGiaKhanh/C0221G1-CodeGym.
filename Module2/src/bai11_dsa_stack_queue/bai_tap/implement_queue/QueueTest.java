package bai11_dsa_stack_queue.bai_tap.implement_queue;

public class Solution{
    public static void main(String[] args) {
        Queue solution = new Queue();
        solution.deQueue();
        solution.enQueue(1);
        solution.enQueue(2);
        solution.enQueue(3);
        solution.deQueue();
        solution.displayQueue();
    }
}
