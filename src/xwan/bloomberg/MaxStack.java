package xwan.bloomberg;

import java.util.Stack;

/**
 * Created by xwan on 1/1/17.
 */
public class MaxStack {
    Stack<Integer> stack;
    int max;

    public MaxStack() {
        stack = new Stack<>();
        max = Integer.MIN_VALUE;
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            max = val;
        } else {
            stack.push(val - max);
            max = Math.max(max, val);
        }
    }

    public int pop() {
        int top = stack.peek();
        if (top > 0) {
            top = max;
            max = max - stack.pop();
        } else {
            top = max + stack.pop();
        }
        return top;
    }

    public int top() {
        if (stack.peek() > 0) {
            return max;
        } else {
            return max + stack.peek();
        }
    }

    public int max() {
        return max;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        MaxStack maxStack = new MaxStack();
        maxStack.push(5);
        maxStack.push(3);
        maxStack.push(4);
        maxStack.push(6);
        maxStack.push(2);

//        System.out.println(maxStack.max());
        System.out.println(maxStack.pop());
        System.out.println(maxStack.pop());
//        System.out.println(maxStack.max());
        System.out.println(maxStack.pop());
//        System.out.println(maxStack.max());
        System.out.println(maxStack.pop());
        System.out.println(maxStack.isEmpty());
        System.out.println(maxStack.pop());

    }
}
