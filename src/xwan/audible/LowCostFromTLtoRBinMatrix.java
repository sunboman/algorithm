package xwan.audible;

/**
 * Created by xwan on 2/3/17.
 */

/**
 *  given a matrix, you can move right or down only and cost of each move is 1.
 *  Find an optimal way to reach to right-bottom from top-left of the matrix.
 *
 */
public class LowCostFromTLtoRBinMatrix {
    public static int lowCost(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        dp[0][0] = matrix[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,1}, {2,6,4,2}, {0,2,6,5}};
        System.out.println(lowCost(matrix));
    }
}
