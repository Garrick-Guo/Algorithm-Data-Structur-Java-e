package LinkedList;

public class ListNode {
    public int value;
    public ListNode next;
    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }
    static ListNode arrayToListNode(int[] array) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int number : array) {
            cur.next = new ListNode(number);
            cur = cur.next;
        }
        return dummy.next;
    }
    static ListNode arrayToListNodeCycle(int[] array) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode pre = null;
        for (int number : array) {
            cur.next = new ListNode(number);
            pre = cur;
            cur = cur.next;
        }
        pre.next = dummy.next;
        return dummy.next;
    }
    static void displayListNode(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.value + "->");
            cur = cur.next;
        }
        System.out.println("null");
    }
}
