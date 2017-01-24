package xwan.lintcode.linked_list;

/**
 * Created by xwan on 11/28/16.
 */
public class reverse_nodes_in_k_group {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * @param head a ListNode
     * @param k an integer
     * @return a ListNode
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        // Write your code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        ListNode node = head;
        ListNode kPre = node;
        int count = 0;

        while (node != null) {
            count++;
            if (count % k == 0) {
                ListNode next = node.next;
                node.next = null;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = reverse(kPre);
                node = next;
                kPre = node;
            } else {
                node = node.next;
            }
        }

        if (kPre != null) {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = kPre;
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;

            head = next;
        }

        return pre;
    }

    public static void main(String[]args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        ListNode res = reverseKGroup(head, 2);
    }
}
