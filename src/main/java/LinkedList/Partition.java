package LinkedList;
/*
Given a linked list and a target value T, partition it such that all nodes less than T are listed before the nodes larger
than or equal to target value T. The original relative order of the nodes in each of the two partitions should be preserved.

Examples
L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3, is partitioned to 2 -> 1 -> 4 -> 3 -> 5 -> null
 */
public class Partition {
    public static void main(String[] args) {
        Partition obj = new Partition();
        ListNode head = ListNode.arrayToListNode(new int[]{3, 2, 1, 5, 6, 0, -1, 9});
        ListNode.displayListNode(obj.partition(head, 4));
    }
    private ListNode partition(ListNode head, int target) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode small = new ListNode(Integer.MIN_VALUE);
        ListNode large = new ListNode(Integer.MAX_VALUE);
        ListNode curSmall = small;
        ListNode curLarge = large;
        ListNode cur = head;
        while (cur != null) {
            if (cur.value < target) {
                curSmall.next = cur;
                curSmall = curSmall.next;
            } else {
                curLarge.next = cur;
                curLarge = curLarge.next;
            }
            cur = cur.next;
        }
        curSmall.next = large.next;
        return small.next;
    }
}
