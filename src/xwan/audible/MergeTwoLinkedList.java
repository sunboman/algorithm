package xwan.audible;

/**
 * Created by xwan on 2/3/17.
 */

/**
 * Merge two unsorted linked lists into one sorted linkedlist.
 */
public class MergeTwoLinkedList {
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }
    public ListNode mergeeList(ListNode l1, ListNode l2) {
        l1 = quickSort(l1);
        l2 = quickSort(l2);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    node.next = l1;
                    l1 = l1.next;
                } else {
                    node.next = l2;
                    l2 = l2.next;
                }
            } else if (l1 != null) {
                node.next = l1;
                l1 = l1.next;
            } else if (l2 != null) {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        return dummy.next;
    }

    private ListNode getMid(ListNode node) {
        ListNode slow = node;
        ListNode fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode quickSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode leftDummy = new ListNode(0);
        ListNode leftTail = leftDummy;
        ListNode midDummy = new ListNode(0);
        ListNode midTail = midDummy;
        ListNode rightDummy = new ListNode(0);
        ListNode rightTail = rightDummy;

        ListNode mid = getMid(head);
        while (head != null) {
            if (head.val < mid.val) {
                leftTail.next = head;
                leftTail = head;
            } else if (head.val > mid.val) {
                rightTail.next = head;
                rightTail = head;
            } else {
                midTail.next = head;
                midTail = head;
            }
            head = head.next;
        }

        leftTail.next = null;
        midTail.next = null;
        rightTail.next = null;

        ListNode left = quickSort(leftDummy.next);
        ListNode right = quickSort(rightDummy.next);

        return concat(left, midDummy.next, right);
    }

    private ListNode concat(ListNode left, ListNode mid, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        node.next = left;
        node = getTail(node);
        node.next = mid;
        node = getTail(node);
        node.next = right;
        node = getTail(node);

        return dummy.next;
    }

    private ListNode getTail(ListNode head) {
        if (head == null) {
            return null;
        }
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        MergeTwoLinkedList m = new MergeTwoLinkedList();
        ListNode head = m.new ListNode(4);
        ListNode n1 = m.new ListNode(2);
        ListNode n2 = m.new ListNode(1);
        ListNode n3 = m.new ListNode(5);
        ListNode n4 = m.new ListNode(7);
        ListNode n5 = m.new ListNode(6);

        n4.next = n5;
        n3.next = n4;
        n2.next = n3;
        n1.next = n2;
        head.next = n1;

        ListNode l2 = m.new ListNode(5);
        ListNode ln1 = m.new ListNode(3);
        ListNode ln2 = m.new ListNode(8);
        ListNode ln3 = m.new ListNode(10);
//        ListNode ln4 = m.new ListNode(8);
//        ListNode ln5 = m.new ListNode(6);

//        ln4.next = ln5;
//        ln3.next = ln4;
        ln2.next = ln3;
        ln1.next = ln2;
        l2.next = ln1;

        m.printList(head);
        m.printList(l2);
        m.printList(m.mergeeList(head, l2));



//        m.printList(head);
//        ListNode newHead = m.quickSort(head);
//        m.printList(newHead);
    }

}
