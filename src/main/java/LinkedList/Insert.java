package LinkedList;
/*
Insert a value in a sorted linked list.
Examples
L = null, insert 1, return 1 -> null
L = 1 -> 3 -> 5 -> null, insert 2, return 1 -> 2 -> 3 -> 5 -> null
L = 1 -> 3 -> 5 -> null, insert 3, return 1 -> 3 -> 3 -> 5 -> null
L = 2 -> 3 -> null, insert 1, return 1 -> 2 -> 3 -> null
 */
public class Insert {
    public static void main(String[] args) {
        Insert obj = new Insert();
        ListNode head = ListNode.arrayToListNode(new int[]{1,2, 3, 4, 5, 9, 11, 12});
        ListNode.displayListNode(head);
        ListNode.displayListNode(obj.insert(head, 7));

    }
    private ListNode insert(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        if (head == null || head.value >= value) {
            newNode.next = head;
            return newNode;
        }
        ListNode pre = head;
        while (pre.next != null && pre.next.value < value) {
            pre = pre.next;
        }
        newNode.next = pre.next;
        pre.next = newNode;
        return head;
    }
}
//Time Complexiy: O(n)
//Space Complexiy: O(1)