package xwan.leetcode.data_structure;

import java.util.Stack;

/**
 * Created by xwan on 12/26/16.
 */
public class ImplementQueueWithStacks232 {
    Stack<Integer> queue = new Stack<>();
    public void push(int x) {
        Stack<Integer> temp = new Stack<>();
        while (!queue.isEmpty()) {
            temp.push(queue.pop());
        }
        temp.push(x);
        while (!temp.isEmpty()) {
            queue.push(temp.pop());
        }
    }

    public void pop() {
        if (queue.isEmpty()) {
            return;
        }
        queue.pop();
    }

    public int top() {
        return queue.pop();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
