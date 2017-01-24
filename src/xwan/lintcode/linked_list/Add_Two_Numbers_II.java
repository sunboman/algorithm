package xwan.lintcode.linked_list;

/**
 * Created by xwan on 12/22/16.
 */
public class Add_Two_Numbers_II {
    static class ListNode {
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode l11 = reverse(l1);
        ListNode l22 = reverse(l2);

        ListNode reverseRes = new ListNode(-1);
        ListNode dummy = reverseRes;
        int carry = 0;

        while (l11 != null && l22 != null) {
            dummy.next = new ListNode((l11.val + l22.val + carry) % 10);
            carry = (l11.val + l22.val) / 10;

            dummy = dummy.next;
            l11 = l11.next;
            l22 = l22.next;
        }
        while (l11 != null) {
            dummy.next = new ListNode((l11.val + carry) % 10);
            carry = l11.val / 10;

            dummy = dummy.next;
            l11 = l11.next;
        }
        while (l22 != null) {
            dummy.next = new ListNode((l22.val + carry) % 10);
            carry = l22.val / 10;

            dummy = dummy.next;
            l22 = l22.next;
        }
        while (carry != 0) {
            dummy.next = new ListNode(carry % 10);
            carry /= 10;

            dummy = dummy.next;
        }

        return reverse(reverseRes.next);
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = head;
        ListNode node = head.next;
        pre.next = null;

        while (node != null) {
            ListNode tmp = node.next;
            node.next = pre;
            pre = node;
            node = tmp;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode l11 = new ListNode(2);
        ListNode l111 = new ListNode(4);
        ListNode l1111 = new ListNode(3);
        l111.next = l1111;
        l11.next = l111;
        l1.next = l11;

        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l222 = new ListNode(4);
        l22.next = l222;
        l2.next = l22;

//        reverse(l1);
        addTwoNumbers(l1, l2);

        System.out.println("test");
    }
}
