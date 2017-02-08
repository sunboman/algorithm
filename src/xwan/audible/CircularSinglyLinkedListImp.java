package xwan.audible;

/**
 * Created by xwan on 2/3/17.
 */

/**
 * Implement a circular singly linked list.
 */
public class CircularSinglyLinkedListImp {
    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            next = null;
        }
    }

    private static int size;
    Node head;
    Node tail;

    public CircularSinglyLinkedListImp() {
        size = 0;
        head = tail = null;
    }

    public void addNodeAtStart(int value) {
        Node node = new Node(value);
        if (size == 0) {
            head = node;
            tail = node;
            node.next = head;
        } else {
            node.next = head;
            head = node;
            tail.next = head;
        }
        size++;
    }

    public void addNodeAtEnd(int value) {
        if (size == 0) {
            addNodeAtStart(value);
        } else {
            Node node = new Node(value);
            tail.next = node;
            tail = node;
            tail.next = head;
            size++;
        }
    }

    public int deleteNodeFromStart() {
        if (size == 0) {
            return -1;
        }
        Node del = head;
        head = head.next;
        tail.next = head;
        size--;
        return del.val;
    }

    public int elementAt(int idx) {
        if (idx > size) {
            idx %= size;
        }
        Node node = head;
        while (idx - 1 != 0) {
            node = node.next;
        }
        return node.val;
    }

    public void pint(CircularSinglyLinkedListImp list) {
        for (int i = 0; i < list.size; i++) {
            System.out.print(list.head.val + "->");
            list.head = list.head.next;
        }
        System.out.println(list.head.val);
    }
    public static void main(String[] args) {
        CircularSinglyLinkedListImp list = new CircularSinglyLinkedListImp();
        list.addNodeAtStart(1);
        list.addNodeAtEnd(4);
        list.addNodeAtStart(3);
        list.addNodeAtStart(5);
        list.deleteNodeFromStart();
        list.pint(list);
    }
}
