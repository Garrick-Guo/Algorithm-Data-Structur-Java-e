package LinkedList;
/*
You are given two linked lists representing two non-negative numbers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

Example
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
public class AddTwoNumber {
    public static void main(String[] args) {
        AddTwoNumber obj = new AddTwoNumber();
        ListNode headOne = ListNode.arrayToListNode(new int[]{2,4,3,9});
        ListNode headTwo = ListNode.arrayToListNode(new int[]{5,6,4,9});
        ListNode.displayListNode(obj.addTwoNumber(headOne, headTwo));
    }
    private ListNode addTwoNumber(ListNode one, ListNode two) {
        if (one == null && two == null) {
            return null;
        }
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode cur = dummy;
        int value = 0;
        while (one != null || two != null || value != 0) {
            if (one != null) {
                value += one.value;
                one = one.next;
            }
            if (two != null) {
                value += two.value;
                two = two.next;
            }
            cur.next = new ListNode(value % 10);
            cur = cur.next;
            value /= 10;
        }
        return dummy.next;
    }

}
//Time Complexity : O(max(n, m))
//Space Complexity: O(max(n, m))
