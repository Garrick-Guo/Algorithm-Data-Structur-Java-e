package stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/*
mplement a stack containing integers using queue(s).
The stack should provide push(x), pop(), top() and isEmpty() operations.
if the stack is empty, then top() and pop() will return null.
 */
public class StackByQueue {
    private Queue<Integer> queue;

    public StackByQueue() {
        queue = new LinkedList<>();
    }
    private boolean isEmpty() {
        if (queue.size() == 0) {
            return true;
        }
        return false;
    }
    private int top() {
        if (queue.isEmpty()) {
            return -1;
        }
        int top = pop();
        queue.offer(top);
        return top;
    }
    private int pop() {
        if (queue.isEmpty()) {
            return -1;
        }
        int size = queue.size() -1;
        while (size != 0) {
            queue.offer(queue.poll());
            size--;
        }
        return queue.poll();
    }


    private void push(int value) {
        queue.offer(value);
    }

    public static void main(String[] args) {
        StackByQueue obj = new StackByQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.top());
    }
}
