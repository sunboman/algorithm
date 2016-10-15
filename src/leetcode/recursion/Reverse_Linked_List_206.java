package leetcode.recursion;

/**
 * Created by sunbo_000 on 10/14/2016.
 */

/*
    https://leetcode.com/problems/reverse-linked-list/
 */

public class Reverse_Linked_List_206 {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*
        Iterative
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode l1 = head;
        ListNode l2 = l1.next;
        head.next = null;
        while (l1 != null && l2 != null) {
            ListNode temp = l2.next;
            l2.next = l1;
            l1 = l2;
            l2 = temp;
        }

        return l1;
    }

    /*
        Recursive
     */
    public ListNode reversList_recur(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reversList_recur(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public static void main(String[] args) {
        Reverse_Linked_List_206 solution = new Reverse_Linked_List_206();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        one.next = two;
        two.next = three;
        solution.reversList_recur(one);
    }
}
