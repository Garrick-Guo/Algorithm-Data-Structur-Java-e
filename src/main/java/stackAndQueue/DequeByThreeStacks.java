package stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/*
Implement a deque by using three stacks. The queue should provide
size(), isEmpty(), offerFirst(), offerLast(), pollFirst(), pollLast(), peekFirst() and peekLast() operations.
When the queue is empty, pollFirst(), pollLast(), peekFirst() and peek() should return null.
 */
public class DequeByThreeStacks {
    private Deque<Integer> left;
    private Deque<Integer> right;
    private Deque<Integer> buffer;

    public DequeByThreeStacks() {
        left = new LinkedList<>();
        right = new LinkedList<>();
        buffer = new LinkedList<>();
    }
    private boolean isEmpty() {
        return size() == 0;
    }

    private int size() {
        return left.size() + right.size();
    }
    private void offerFirst(int element) {
        left.offerFirst(element);
    }
    private void offerLast(int element) {
        right.offerFirst(element);
    }
    private Integer pollFirst() {
        if(isEmpty()){
            return null;
        }
        if (left.isEmpty()) {
            moveTo(right, left);
        }
        return left.pollFirst();

    }
    private Integer pollLast() {
        if(isEmpty()){
            return null;
        }
        if (right.isEmpty()) {
            moveTo(left, right);
        }
        return right.pollFirst();
    }

    private Integer peekFirst() {
        if (isEmpty()) {
            return null;
        }
        if (left.isEmpty()) {
            moveTo(right, left);
        }
        return left.peekFirst();
    }
    private Integer peekLast() {
        if (isEmpty()) {
            return null;
        }
        if (right.isEmpty()) {
            moveTo(left, right);
        }
        return right.peekFirst();
    }

    private void moveTo(Deque<Integer> src, Deque<Integer> dest) {
        int half = src.size() / 2;
        for (int i = 0; i < half; i++) {
            buffer.offerFirst(src.pollFirst());
        }
        while (!src.isEmpty()) {
            dest.offerFirst(src.pollFirst());
        }
        while (!buffer.isEmpty()) {
            src.offerFirst(buffer.pollFirst());
        }
    }

    public static void main(String[] args) {
        DequeByThreeStacks deque = new DequeByThreeStacks();
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        deque.offerFirst(4);
        deque.offerLast(5);
        deque.offerLast(6);
        deque.offerLast(7);
        deque.offerLast(8);
        System.out.println(deque.pollFirst()); //4
        System.out.println(deque.pollLast()); // 8
        System.out.println(deque.pollFirst()); // 3
        System.out.println(deque.pollFirst()); // 2
        System.out.println(deque.pollFirst()); // 1
        System.out.println(deque.pollFirst()); // 5
    }

}
