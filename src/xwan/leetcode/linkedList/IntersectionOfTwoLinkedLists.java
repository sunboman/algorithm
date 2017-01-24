package xwan.leetcode.linkedList;

import xwan.lintcode.linked_list.Add_Two_Numbers_II;

/**
 * Created by xwan on 12/25/16.
 */
public class IntersectionOfTwoLinkedLists {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode dummy = headA;
        ListNode tailA = dummy;
        while (tailA.next != null) {
            tailA = tailA.next;
        }
        tailA.next = headB;
        ListNode slow = dummy;
        ListNode fast = dummy.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;

        }
        slow = headA;
        fast = fast.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        tailA.next = null;
        return slow;
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

        getIntersectionNode(l1, l2);
    }
}
