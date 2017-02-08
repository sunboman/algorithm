package xwan.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by xwan on 2/7/17.
 */
public class NextGreaterElementII503 {
    public static int[] nextGreaterElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] tmp = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            tmp[i] = nums[i % n];
        }
        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && tmp[stack.peek()] < tmp[i]) {
                if (!map.containsKey(stack.peek() % n)) {
                    map.put(stack.pop() % n, tmp[i]);
                } else {
                    stack.pop();
                }
            }
            stack.push(i);
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = map.getOrDefault(i, -1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,4,2,3};
        nextGreaterElements(nums);
    }
}
