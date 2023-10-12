package LinkedList;
/*
Find the middle node of a given linked list.

Examples
L = null, return null
L = 1 -> null, return 1
L = 1 -> 2 -> null, return 1
L = 1 -> 2 -> 3 -> null, return 2
L = 1 -> 2 -> 3 -> 4 -> null, return 2
 */
public class MiddleNode {
    public static void main(String[] args) {
        MiddleNode obj = new MiddleNode();
        ListNode head = ListNode.arrayToListNode(new int[]{1,2,3,4});
        ListNode middle = obj.findMiddle(head);
        System.out.println(middle.value);
    }
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(1)
