package xwan.bloomberg;

/**
 * Created by xwan on 1/3/17.
 */
public class ReorderList149 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = getMid(head);
        ListNode rev_mid = reverse(mid.next);
        ListNode node = head;
        while (rev_mid != null) {
            ListNode node_next = node.next;
            ListNode rev_next = rev_mid.next;
            node.next = rev_mid;
            rev_mid.next = node_next;
            node = node_next;
            rev_mid = rev_next;
        }
        node.next = null;
    }
    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode node = head;
        while (node != null) {
            ListNode tmp = node.next;
            node.next = pre;
            pre = node;
            node = tmp;
        }
        return pre;
    }
}
