package LinkedList;
/*
Given a linked list, check whether it is a palindrome.
Examples:
Input:   1 -> 2 -> 3 -> 2 -> 1 -> null  output: true.
Input:   1 -> 2 -> 3 -> null            output: false.
Requirements: Space complexity must be O(1)
 */
public class IsPalindrome {
    public static void main(String[] args) {
        IsPalindrome obj = new IsPalindrome();
        ListNode head = ListNode.arrayToListNode(new int[]{1,2,3,4,2,1});
        ListNode head2 = ListNode.arrayToListNode(new int[]{1,2,3,2,1});
        System.out.println(obj.isPalindrome(head));
        System.out.println(obj.isPalindrome(head2));
    }
    private boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode middle = findMiddle(head);
        ListNode two = reserve(middle);
        middle.next = null;
        ListNode one = head;
        return isSame(one, two);
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
    private ListNode reserve(ListNode head) {
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
    private boolean isSame(ListNode one, ListNode two) {
        while (one != null && two != null) {
            if (one.value != two.value) {
                return false;
            }
            one = one.next;
            two = two.next;
        }
        if (one != null || two != null) {
            return false;
        }
        return true;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(1)
