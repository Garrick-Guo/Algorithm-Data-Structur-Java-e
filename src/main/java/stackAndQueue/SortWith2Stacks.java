package stackAndQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
Given an array that is initially stored in one stack, sort it with one additional stacks (total 2 stacks).
After sorting the original stack should contain the sorted integers and from top to bottom the integers are sorted in ascending order.
Assumptions:
The given stack is not null.
There can be duplicated numbers in the give stack.
Requirements:
No additional memory, time complexity = O(n ^ 2).
 */
public class SortWith2Stacks {
    public static void main(String[] args) {
        SortWith2Stacks obj = new SortWith2Stacks();
        Deque<Integer> stack1 = new LinkedList<>();
        stack1.add(2);
        stack1.add(1);
        stack1.add(3);
        stack1.add(0);
        stack1.add(4);
        obj.sort(stack1);

    }
    private void sort(Deque<Integer> stack1) {
        if (stack1 == null || stack1.size() <= 1) {
            return;
        }
        Deque<Integer> stack2 = new LinkedList<>();
        sort(stack1, stack2);
    }

    private void sort(Deque<Integer> input, Deque<Integer> buffer) {
        while (!input.isEmpty()) {
            int curMin = Integer.MAX_VALUE;
            int count = 0;
            while (!input.isEmpty()) {
                int cur = input.pollFirst();
                if (cur < curMin) {
                    curMin = cur;
                    count = 1;
                } else if (cur == curMin){
                    count++;
                }
                buffer.offerFirst(cur);
            }
            while (!buffer.isEmpty() && buffer.peekFirst() >= curMin) {
                2
            }
        }
    }
}
