package LinkedList;
/*
Remove all elements from a linked list of integers that have value val.
Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement obj = new RemoveElement();
        ListNode head = ListNode.arrayToListNode(new int[]{1,2,6,3,4,5,6});
        ListNode.displayListNode(obj.delect(head, 6));
    }
    private ListNode delect(ListNode head, int value) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null) {
            if (cur.value == value) {
                pre.next = cur.next;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
//Time Complexity = O(n)
//Space Complexity = O(1)
