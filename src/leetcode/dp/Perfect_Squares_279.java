package leetcode.dp;

/**
 * Created by sunbo_000 on 10/21/2016.
 */

/*
    https://leetcode.com/problems/perfect-squares/
    Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which
    sum to n.

    For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */

public class Perfect_Squares_279 {
    /*
        dp[i] = min{dp[i],dp[i-sqrt]+1}
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = i;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sqrt; j++) {
                if (i == j * j) dp[i] = 1;
                else if (i > j * j) dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Perfect_Squares_279().numSquares(13));
    }
}
