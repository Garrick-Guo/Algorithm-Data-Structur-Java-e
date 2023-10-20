package LinkedList;
/*
Given a singly-linked list, where each node contains an integer value, sort it in ascending order.
The merge sort algorithm should be used to solve this problem.

Examples
null, is sorted to null
1 -> null, is sorted to 1 -> null
1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to -3 -> 2 -> 4 -> 5 -> 6
 */
public class MergeSort {
    public static void main(String[] args) {
        MergeSort obj = new MergeSort();
        ListNode head = ListNode.arrayToListNode(new int[]{4,2,6,-3,5,1});
        ListNode.displayListNode(obj.mergeSort(head));
    }
    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = findMiddle(head);
        ListNode middleNext = middle.next;
        middle.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(middleNext);
        return merge(left, right);
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
    private ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummy;
        ListNode curOne = one;
        ListNode curTwo = two;
        while (curOne != null && curTwo != null) {
            if (curOne.value < curTwo.value) {
                cur.next = curOne;
                curOne = curOne.next;
            } else {
                cur.next = curTwo;
                curTwo = curTwo.next;
            }
            cur = cur.next;
        }
        if (curOne != null) {
            cur.next = curOne;
        }
        if (curTwo != null) {
            cur.next = curTwo;
        }
        return dummy.next;
    }

}
//Time Complexity : O(nlogn)
//Space Complexity : O(logn)
