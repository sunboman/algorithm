package leetcode.dp;

/**
 * Created by sunbo_000 on 10/21/2016.
 */

/*
    https://leetcode.com/problems/house-robber/

    You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
    the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
    it will automatically contact the police if two adjacent houses were broken into on the same night.

    Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
    money you can rob tonight without alerting the police.
 */
public class House_Robber_198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[2];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int index = i % 2;
            dp[index] = Math.max(dp[index] + nums[i], dp[(index + 1) % 2]);
        }

        return Math.max(dp[0], dp[1]);
    }

    public static void main(String[] args) {
        System.out.println(new House_Robber_198().rob(new int[]{2, 3, 2}));
    }
}
