package LinkedList;
/*
Check if a given linked list has a cycle. Return true if it does, otherwise return false.
Assumption:
You can assume there is no duplicate value appear in the linked list.
 */
public class HasCycle {
    public static void main(String[] args) {
        HasCycle obj = new HasCycle();
        ListNode head = ListNode.arrayToListNodeCycle(new int[]{1,2,3,4,5,6});
        ListNode head1 = ListNode.arrayToListNode(new int[]{1,2,3,4,5});
        System.out.println(obj.hasCycle(head));
        System.out.println(obj.hasCycle(head1));
    }
    private boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
