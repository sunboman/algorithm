package xwan.leetcode.linkedList;

/**
 * Created by xwan on 12/26/16.
 */
public class ReverseLinkedList206 {
    public static ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
}
