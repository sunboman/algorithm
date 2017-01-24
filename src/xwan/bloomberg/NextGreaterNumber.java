package xwan.bloomberg;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by xwan on 1/4/17.
 */
public class NextGreaterNumber {
    public static int[] nextGreater(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < nums.length; i++) {
            if (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    res[stack.pop()] = nums[i];
                }
            }
            if (stack.isEmpty() || nums[stack.peek()] >= nums[i]) {
                stack.push(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 5, 4, 7, 8, 5};
        nextGreater(nums);
    }
}
