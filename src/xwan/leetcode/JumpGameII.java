package xwan.leetcode;

/**
 * Created by xwan on 2/27/17.
 */

/**
 * 45. Jump Game II
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 For example:
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class JumpGameII {
    public static int jump(int[] nums) {
        if (nums.length < 2) return 0;
        int steps = 0;
        int currMax = 0;
        int nextMax = 0;
        int i = 0;
        int n = nums.length;
        while (currMax - i + 1 > 0) {
            steps++;
            while (i <= currMax) {
                nextMax = Math.max(nextMax, i + nums[i]);
                if (nextMax >= n - 1) return steps;
                i++;
            }
            currMax = nextMax;
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
