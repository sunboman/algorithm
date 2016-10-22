package leetcode.dp;

/**
 * Created by sunbo_000 on 10/21/2016.
 */

/*
    https://leetcode.com/problems/minimum-path-sum/
    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes
    the sum of all numbers along its path.

 */

public class Minimum_Path_Sum_64 {
    /*
        dp[i][j] = min(dp[i-1][j],dp[i][j-1])
     */
    public int minPathSum(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1) return grid[0][0];
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;
                if (i - 1 < 0) dp[i][j] = dp[i][j - 1] + grid[i][j];
                else if (j - 1 < 0) dp[i][j] = dp[i - 1][j] + grid[i][j];
                else dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    /*
        Use one way array instead of two way array
     */
    public int minPathSum_2(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1) return grid[0][0];
        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) dp[i] = dp[i - 1] + grid[0][i];
        for (int i = 1; i < grid.length; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < grid[0].length; j++) dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Minimum_Path_Sum_64().minPathSum_2(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
