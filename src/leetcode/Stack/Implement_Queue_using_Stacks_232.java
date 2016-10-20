package leetcode.Stack;

import java.util.LinkedList;

/**
 * Created by sunbo_000 on 10/19/2016.
 */

/*
    https://leetcode.com/problems/implement-queue-using-stacks/
    Implement the following operations of a queue using stacks.

    push(x) -- Push element x to the back of queue.
    pop() -- Removes the element from in front of queue.
    peek() -- Get the front element.
    empty() -- Return whether the queue is empty.
    Notes:
    You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
    Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
    You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */

public class Implement_Queue_using_Stacks_232 {

    private LinkedList<Integer> stack_one = new LinkedList<>();
    private LinkedList<Integer> stack_two = new LinkedList<>();

    // Push element x to the back of queue.
    public void push(int x) {
        stack_one.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (stack_two.isEmpty()) {
            if (stack_one.isEmpty()) throw new RuntimeException();
            while (!stack_one.isEmpty()) {
                stack_two.push(stack_one.pop());
            }
        }
        stack_two.pop();
    }

    // Get the front element.
    public int peek() {
        if (stack_two.isEmpty()) {
            if (stack_one.isEmpty()) throw new RuntimeException();
            while (!stack_one.isEmpty()) {
                stack_two.push(stack_one.pop());
            }
        }
        return stack_two.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack_one.isEmpty() && stack_two.isEmpty();
    }
}
