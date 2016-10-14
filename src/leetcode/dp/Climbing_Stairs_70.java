package leetcode.dp;

/**
 * Created by sunbo_000 on 10/13/2016.
 */

/*
    https://leetcode.com/problems/climbing-stairs/
 */
public class Climbing_Stairs_70 {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[3];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i % 3] = dp[(i - 1) % 3] + dp[(i - 2) % 3];
        }
        return dp[(n - 1) % 3];
    }


    public static void main(String[] args) {
        Climbing_Stairs_70 solution = new Climbing_Stairs_70();
        System.out.println(solution.climbStairs(4));
    }
}
