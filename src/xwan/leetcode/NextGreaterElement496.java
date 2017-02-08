package xwan.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by xwan on 2/6/17.
 */
public class NextGreaterElement496 {
    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        int n = findNums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int j = 0;
            while (j < nums.length && nums[j] != findNums[i]) {
                j++;
            }
            for (j = j + 1; j < nums.length; j++) {
                if (nums[j] > findNums[i]) {
                    res[i] = nums[j];
                    break;
                }
            }
            if (res[i] == 0) {
                res[i] = -1;
            }
        }
        return res;

    }

    public int[] nextGreaterElementI(int[] findNums, int[] nums) {
        int n = findNums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for (int i = 0; i < n; i++) {
            res[i] = map.getOrDefault(findNums[i], -1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num1 = {3,1,5,7,9,2,6};
        int[] num2 = {1,2,3,5,6,7,9,11};
        nextGreaterElement(num1, num2);
    }
}
