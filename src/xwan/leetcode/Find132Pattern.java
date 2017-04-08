package xwan.leetcode;

import java.util.LinkedList;

/**
 * Created by xwan on 3/21/17.
 */

/**
 * 456. 132 Pattern
 *
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.

 Note: n will be less than 15,000.

 Example 1:
 Input: [1, 2, 3, 4]

 Output: False

 Explanation: There is no 132 pattern in the sequence.
 Example 2:
 Input: [3, 1, 4, 2]

 Output: True

 Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 Example 3:
 Input: [-1, 3, 2, 0]

 Output: True

 Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 */
public class Find132Pattern {
    public static boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int n = nums.length;
        int secMax = Integer.MAX_VALUE;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < secMax) return true;
            else {
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    secMax = stack.pop();
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2};
        System.out.println(find132pattern(nums));
    }
}
