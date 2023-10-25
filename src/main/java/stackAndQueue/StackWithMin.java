package stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/*
Enhance the stack implementation to support min() operation. min() should return the current minimum value in the stack.
If the stack is empty, min() should return -1.
push(int element) - push the element to top
pop() - return the top element and remove it, if the stack is empty, return -1
top() - return the top element without remove it, if the stack is empty, return -1
min() - return the current min value in the stack.
 */
public class StackWithMin {
    private Deque<Integer> inputStack;
    private Deque<Integer> minStack;
    public StackWithMin(){
        inputStack = new LinkedList<>();
        minStack = new LinkedList<>();
    }
    private void push(int value) {
        if (minStack.isEmpty() || minStack.peekFirst() >= value) {
            minStack.offerFirst(value);
        }
        inputStack.offerFirst(value);
    }
    private int pop(){
        if (minStack.peekFirst() == inputStack.peekFirst()) {
            minStack.pollFirst();
        }
        return inputStack.pollFirst();
    }
    private int top(){
        return inputStack.peekFirst();
    }
    private int min(){
        return minStack.peekFirst();
    }
    public static void main(String[] args) {
        StackWithMin obj = new StackWithMin();
        obj.push(3);
        obj.push(2);
        obj.push(0);
        obj.push(1);
        obj.pop();
        obj.pop();
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.min());
    }
    //Time Complexity: O(1)
    //Space Complexity: O(n)
}
