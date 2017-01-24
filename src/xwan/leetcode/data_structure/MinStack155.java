package xwan.leetcode.data_structure;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by xwan on 12/26/16.
 */
public class MinStack155 {
    int min;
    Stack<Integer> stack;
    public MinStack155() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return min;
    }

    public static void main(String[] args) {

    }
}
