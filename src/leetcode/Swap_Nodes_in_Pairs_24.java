package leetcode;

/**
 * Created by sunbo_000 on 10/20/2016.
 */
/*
    https://leetcode.com/problems/swap-nodes-in-pairs/
    Given a linked list, swap every two adjacent nodes and return its head.

    For example,
    Given 1->2->3->4, you should return the list as 2->1->4->3.

    Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class Swap_Nodes_in_Pairs_24 {


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0);
        ListNode curr = newHead;
        curr.next = head;
        while (curr != null) {
            if (curr.next == null || curr.next.next == null) break;
            ListNode next = curr.next;
            ListNode next_next = next.next;
            curr.next = next_next;
            next.next = next_next.next;
            next_next.next = next;
            curr = next;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        one.next = two;
        two.next = three;
//        three.next = four;

        Swap_Nodes_in_Pairs_24 solution = new Swap_Nodes_in_Pairs_24();
        ListNode result = solution.swapPairs(one);
        String stop = "";
    }
}
