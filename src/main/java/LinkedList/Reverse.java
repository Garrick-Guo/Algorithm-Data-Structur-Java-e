package LinkedList;
/*
Reverse a singly-linked list iteratively.
Examples

L = null, return null
L = 1 -> null, return 1 -> null
L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null
 */
public class Reverse {
    public static void main(String[] args) {
        Reverse obj = new Reverse();
        int[] array = new int[]{1,2,3,4,5,6,7};
        ListNode head = ListNode.arrayToListNode(array);
        ListNode newHead = obj.reverse(head);
        ListNode.displayListNode(newHead);
    }
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
//Time Complexity: O(n);
//Space Complexity: O(1)
