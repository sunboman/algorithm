package xwan.leetcode.linkedList;

/**
 * Created by xwan on 12/26/16.
 */
public class AddTwoNumbersII445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            carry = val / 10;
            dummy.next = new ListNode(val % 10);
            dummy = dummy.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int val = l1.val + carry;
            carry = val / 10;
            dummy.next = new ListNode(val % 10);
            dummy = dummy.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int val = l2.val + carry;
            carry = val / 10;
            dummy.next = new ListNode(val % 10);
            dummy = dummy.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            dummy.next = new ListNode(carry);
        }
        return res.next;
    }
}


