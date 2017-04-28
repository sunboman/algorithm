package leetcode;

/**
 * Created by bosun on 4/28/17.
 */
public class Guess_Number_Higher_Lower_375 {
  public int getMoneyAmount(int n) {
    int[][] dp = new int[n + 2][n + 2];
    for (int len = 2; len <= n; len++) {
      for (int i = 1; i <= n - len + 1; i++) {
        dp[i][i + len - 1] = Integer.MAX_VALUE;
        for (int j = i; j < i + len; j++) {
          int guess = j + Math.max(dp[i][j - 1], dp[j + 1][i + len - 1]);
          dp[i][i + len - 1] = Math.min(dp[i][i + len - 1], guess);
        }
      }
    }
    return dp[1][n];
  }

  public static void main(String[] args) {
    new Guess_Number_Higher_Lower_375().getMoneyAmount(3);
  }
}
