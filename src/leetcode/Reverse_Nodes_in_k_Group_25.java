package leetcode;

/**
 * Created by sunbo_000 on 10/23/2016.
 */

/*
    https://leetcode.com/problems/reverse-nodes-in-k-group/
    Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

    If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

    You may not alter the values in the nodes, only nodes itself may be changed.

    Only constant memory is allowed.

    For example,
    Given this linked list: 1->2->3->4->5

    For k = 2, you should return: 2->1->4->3->5

    For k = 3, you should return: 3->2->1->4->5
 */

public class Reverse_Nodes_in_k_Group_25 {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    /*
        cut the list into several groups with k nodes then reverse them one by one and combine together
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) return head;
        ListNode reverseHead = head;
        ListNode prvTail = null;
        ListNode l1 = head;
        ListNode l2 = head.next;
        ListNode result = null;
        int count = 1;
        boolean first = true;
        while (l2 != null) {
            l1 = l2;
            l2 = l2.next;
            if (++count == k) {
                l1.next = null;
                if (first) {
                    result = reversKNode(reverseHead);
                    first = false;
                } else prvTail.next = reversKNode(reverseHead);
                prvTail = reverseHead;
                reverseHead = l2;
                count = 0;
            }
        }
        if (first) return head;
        if (reverseHead != null) prvTail.next = reverseHead;
        return result;

    }

    private ListNode reversKNode(ListNode head) {
        ListNode l1 = head;
        ListNode l2 = head.next;
        l1.next = null;
        while (l1 != null && l2 != null) {
            ListNode temp = l2.next;
            l2.next = l1;
            l1 = l2;
            l2 = temp;
        }
        return l1;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ListNode res = new Reverse_Nodes_in_k_Group_25().reverseKGroup(one, 5);
        String stop = "";

    }
}
