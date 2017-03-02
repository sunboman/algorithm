package xwan.leetcode;

/**
 * Created by xwan on 2/23/17.
 */


import leetcode.recursion.Symmetric_Tree_101;

/**
 * Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, please find out a way you can make one square by using up all those matchsticks. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

 Your input will be several matchsticks the girl has, represented with their stick length. Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.

 Example 1:
 Input: [1,1,2,2,2]
 Output: true

 Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
 Example 2:
 Input: [3,3,3,3,4]
 Output: false

 Explanation: You cannot find a way to form a square with all the matchsticks.
 Note:
 The length sum of the given matchsticks is in the range of 0 to 10^9.
 The length of the given matchstick array will not exceed 15.
 */
public class MatchstickstoSquare473 {
    public static boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 4 != 0) return false;
        int target = sum / 4;
        ;
        return helper(nums, new int[4], target, 0);
    }

    private static boolean helper(int[] nums, int[] des, int target, int idx) {
        if (idx == nums.length) {
            if (des[0] == target && des[1] == target && des[2] == target) {
                return true;
            }
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (des[i] + nums[idx] > target) continue;
            des[i] += nums[idx];
            if (helper(nums, des, target, idx + 1)) return true;
            des[i] -= nums[idx];
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2};
        long before = System.currentTimeMillis();
        System.out.println(makesquare(nums));
        long after = System.currentTimeMillis();
        System.out.println(after - before);
    }
}
