package stackAndQueue;

import java.util.LinkedList;

/*
Implement a queue by using two stacks. The queue should provide size(), isEmpty(), offer(), poll() and peek() operations.
When the queue is empty, poll() and peek() should return null.
 */
public class QueuebyTwoStacks {
    //always insert in this stack
    private LinkedList<Integer> in;
    //always remove from this stack
    private LinkedList<Integer> out;
    public QueuebyTwoStacks(){
        in = new LinkedList<>();
        out = new LinkedList<>();
    }
    private Integer poll(){
        move();
        return out.isEmpty() ? null : out.pollFirst();
    }

    private Integer peek() {
        move();
        return out.isEmpty() ? null : out.peekFirst();
    }
    private boolean isEmpty() {
        return size() == 0;
    }
    private Integer size() {
        return in.size() + out.size();
    }
    private void offer(int value) {
        in.offerFirst(value);
    }
    private void move(){
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.offerFirst(in.pollFirst());
            }
        }
    }

    public static void main(String[] args) {
        QueuebyTwoStacks obj = new QueuebyTwoStacks();
        obj.offer(1);
        obj.offer(2);
        obj.offer(3);
        System.out.println(obj.size());
        System.out.println(obj.peek());
        obj.poll();
        System.out.println(obj.isEmpty());
    }

}
