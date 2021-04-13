package bai11_dsa_stack_queue.thuc_hanh.optional_stack;

public class MyStack {
    private int[] arr;
    private int size = 0;
    private int index = 0;

    public MyStack(int size) {
        this.size = size;
        arr = new int[this.size];
    }

    public boolean isEmpty() {
        return index == 0 ? true : false;
    }

    public boolean isFull() {
        return index == size ? true : false;
    }

    public void push(int element) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        arr[index] = element;
        index++;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is full");
        }
        return arr[--index];
    }

    public int size() {
        return index;
    }
}
