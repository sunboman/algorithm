package xwan.leetcode.data_structure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xwan on 12/27/16.
 */
public class ImplementStackWithQueues225 {
    Queue<Integer> queue = new LinkedList<>();
    // Push element x onto stack.ßßß
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        while (size-- > 1) {
            queue.add(queue.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (queue.isEmpty()) {
            return;
        }
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
