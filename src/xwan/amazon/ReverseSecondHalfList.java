package xwan.amazon;


/**
 * Created by xwan on 1/25/17.
 */
public class ReverseSecondHalfList {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode reverseHalf(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = slow;
        ListNode half = slow.next;
        half = reverseList(half);
        pre.next = half;

        return head;
    }
    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static ListNode reverseSecondHalfList(ListNode head) {
        if (head == null || head.next == null)      return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode pre = slow.next;
        ListNode cur = pre.next;
        while (cur != null) {
            pre.next = cur.next;
            cur.next = slow.next;
            slow.next = cur;
            cur = pre.next;
        }
        return head;
    }
    public static void main(String[] args) {
        ReverseSecondHalfList rev = new ReverseSecondHalfList();
        ListNode l1 = rev.new ListNode(7);
        ListNode l11 = rev.new ListNode(2);
        ListNode l111 = rev.new ListNode(4);
        ListNode l1111 = rev.new ListNode(3);
        ListNode l11111 = rev.new ListNode(9);
        l1111.next = l11111;
        l111.next = l1111;
        l11.next = l111;
        l1.next = l11;

//        rev.reverseHalf(l1);
        reverseSecondHalfList(l1);
    }
}
