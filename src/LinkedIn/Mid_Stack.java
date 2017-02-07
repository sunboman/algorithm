package LinkedIn;

/**
 * Created by sunbo on 1/24/2017.
 */
public class Mid_Stack {

    private class Node {
        Node prev, next;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    int n;
    Node middle;
    Node head;

    public Mid_Stack() {
        n = 0;
    }

    public void push(int i) {
        Node newNode = new Node(i);
        if (n == 0) {
            head = newNode;
            middle = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            if (n % 2 != 0) {
                middle = middle.prev;
            }
        }
        n++;
    }

    public int pop() {
        if (head == null) {
            throw new RuntimeException();
        }
        int res = head.val;
        if (n == 1) {
            head = null;
            middle = null;
        } else {
            head = head.next;
            head.prev = null;
            if (n == 2) {
                middle = head;
            } else if (n % 2 == 0) {
                middle = middle.next;
            }
        }
        n--;
        return res;
    }

    public int findMiddle() {
        if (middle == null) {
            throw new RuntimeException();
        }
        return middle.val;
    }

    public void deleteMiddle() {
        if (n == 0) {
            return;
        }
        if (n == 1) {
            n--;
            head = null;
            middle = null;
        } else {
            if (n == 2) {
                head = head.next;
                head.prev = null;
                middle = head;
            } else {
                middle.prev.next = middle.next;
                middle.next.prev = middle.prev;
                if (n % 2 == 0) {
                    middle = middle.next;
                } else {
                    middle = middle.prev;
                }
            }
        }
        n--;
    }

    public static void main(String[] args) {
        Mid_Stack mid_stack = new Mid_Stack();
        mid_stack.push(1);
        mid_stack.push(2);
        mid_stack.push(3);
        mid_stack.push(4);
        mid_stack.push(5);
        mid_stack.findMiddle();
        mid_stack.deleteMiddle();
        mid_stack.pop();

    }
}
