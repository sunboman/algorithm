package leetcode.priority_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by sunbo_000 on 10/14/2016.
 */

/*
    https://leetcode.com/problems/merge-k-sorted-lists/
 */

/*
    Solution: 1. Use priority queue(Space: O(k) Time:O(nklogk)); 2. Divided conquer (Space: O(1) Time: O(nklogk))

 */
public class Merge_k_Sorted_Lists_23 {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null) heap.offer(list);
        }
        ListNode result = new ListNode(0);
        ListNode head = result;
        while (heap.size() > 0) {
            ListNode curr = heap.poll();
            head.next = curr;
            head = head.next;
            if (curr.next != null) heap.offer(curr.next);
        }

        return result.next;
    }


    public ListNode mergeKLists_d(ListNode[] lists) {
        if (lists.length == 0) return null;

        int end = lists.length - 1;
        while (end > 0) {
            int begin = 0;
            while (begin < end) {
                lists[0] = MergeTwoLists(lists[begin], lists[end]);
                begin++;
                end--;
            }
        }

        return lists[0];
    }


    private ListNode MergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 != null) head.next = l1;
        if (l2 != null) head.next = l2;
        return result.next;
    }

}
