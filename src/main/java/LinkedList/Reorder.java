package LinkedList;
/*
Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null
Examples
L = null, is reordered to null
L = 1 -> null, is reordered to 1 -> null
L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
L = 1 -> 2 -> 3 -> null, is reordred to 1 -> 3 -> 2 -> null
 */
public class Reorder {
    public static void main(String[] args) {
        Reorder obj = new Reorder();

    }
    private ListNode reorder(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode one = head;
        ListNode middle = findMiddle(head);
        ListNode two = reverse(middle.next);
        return meger(one, two);
    }
    }private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    private ListNode meger(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(one != null && two != null) {
            cur.next = one;
            cur = cur.next;
            one = one.next;
            cur.next = two;
            cur = cur.next;
            two = two.next;
        }
        if(one != null) {
            cur.next = one;
        }else {
            cur.next = two;
        }
        return dummy.next;
    }

}
