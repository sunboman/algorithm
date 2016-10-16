package leetcode;

/**
 * Created by sunbo_000 on 10/16/2016.
 */

/*
    https://leetcode.com/problems/rotate-list/

    Given a list, rotate the list to the right by k places, where k is non-negative.

    For example:
    Given 1->2->3->4->5->NULL and k = 2,
    return 4->5->1->2->3->NULL.
 */



public class Rotate_List_61 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode fast = head;
        int n = 1;
        while (fast.next != null) {
            fast = fast.next;
            n++;
        }
        fast.next = head;
        k %= n;
        for (int i = 0; i < n - k; i++) {
            if (i == n - k - 1) {
                ListNode tmp = head;
                head = head.next;
                tmp.next = null;
            } else head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        /*two.next = three;
        three.next = four;
        four.next = five;*/
        Rotate_List_61 solution = new Rotate_List_61();
        solution.rotateRight(one, 3);
    }
}
