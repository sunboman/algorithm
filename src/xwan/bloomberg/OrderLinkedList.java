package xwan.bloomberg;

/**
 * Created by xwan on 1/3/17.
 */

/**
 * Give a linkedList with abs order, re-order linkedlist with normal order.
 */
public class OrderLinkedList {
    public static ListNode order(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ans = head;
        ListNode pre = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val < 0) {
                pre.next = curr.next;
                ListNode tmp = curr;
                tmp.next = ans;
                ans = tmp;
                curr = pre.next;
            } else {
                pre = pre.next;
                curr = curr.next;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n = new ListNode(2);
        ListNode n1 = new ListNode(-3);
        ListNode n2 = new ListNode(-5);
        ListNode n3 = new ListNode(6);
        n2.next = n3;
        n1.next = n2;
        n.next = n1;
        head.next = n;

        order(head);
    }

}
