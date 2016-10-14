package leetcode;

import java.util.List;

/**
 * Created by sunbo_000 on 10/13/2016.
 */
public class Merge_Two_Sorted_Lists_21 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = null;
        if(l1.val < l2.val) {
            head = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            head = new ListNode(l2.val);
            l2 = l2.next;
        }
        ListNode result = head;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            head = head.next;
        }

        if(l1 != null) head.next = l1;
        if(l2 != null) head.next = l2;

        return result;
    }
}
