package xwan.leetcode.linkedList;

/**
 * Created by xwan on 12/30/16.
 */
public class SwapNodesInPairs24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            ListNode pre = curr.next;
            ListNode next = curr.next.next;
            pre.next = next.next;
            next.next = pre;
            curr.next = next;
            curr = curr.next.next;
        }
        return dummy.next;
    }

    // solution with recursive
    public ListNode swapPairs_recur(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs_recur(head.next.next);
        next.next = head;
        return next;
    }
}
