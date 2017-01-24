package xwan.lintcode.dinamic_programming;

/**
 * Created by xwan on 10/31/16.
 */

/**
 * 115 Unique Paths II
 *
 * Follow up for "Unique Paths":

     Now consider if some obstacles are added to the grids. How many unique paths would there be?

     An obstacle and empty space is marked as 1 and 0 respectively in the grid.

     Notice

     m and n will be at most 100.

     Have you met this question in a real interview? Yes
     Example
     For example,
     There is one obstacle in the middle of a 3x3 grid as illustrated below.

     [
     [0,0,0],
     [0,1,0],
     [0,0,0]
     ]
     The total number of unique paths is 2.
 *
 * http://www.lintcode.com/en/problem/unique-paths-ii/
 */
public class Unique_Paths_II_115 {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid == null || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[m + 1][n + 1];
        int i, j;
        for (i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        while (i < m) {
            dp[i][0] = 0;
            i++;
        }

        for (j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = 1;
            } else {
                break;
            }
        }
        while (j < n) {
            dp[0][j] = 0;
            j++;
        }

        for (int l = 1; l < m; l++) {
            for (int r = 1; r < n; r++) {
                if (obstacleGrid[l][r] == 0) {
                    dp[l][r] = dp[l - 1][r] + dp[l][r - 1];
                } else {
                    dp[l][r] = 0;
                }
            }
        }

        return dp[m - 1][n - 1];
    }

}
