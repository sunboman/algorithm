package leetcode;

import java.util.Arrays;

/**
 * Created by bosun on 5/3/17.
 */
public class Maximum_Vacation_Gap_568 {


  public int maxVacationDays(int[][] flights, int[][] days) {
    int n = flights.length, k = days[0].length;
    int[] dp = new int[n];
    Arrays.fill(dp, Integer.MIN_VALUE);
    dp[0] = 0;
    for (int w = 0; w < k; w++) {
      int[] temp = new int[n];
      Arrays.fill(temp, Integer.MIN_VALUE);
      for (int t = 0; t < n; t++) {
        for (int s = 0; s < n; s++) {
          if (s == t || flights[s][t] == 1) {
            temp[t] = Math.max(temp[t], dp[s] + days[t][w]);
          }
        }
      }
      dp = temp;
    }
    int res = 0;
    for (int d : dp) res = Math.max(res, d);
    return res;
  }


  public static void main(String[] args) {
    new Maximum_Vacation_Gap_568().maxVacationDays(
            new int[][]{
                    {0, 1, 1},
                    {1, 0, 1},
                    {1, 1, 0}
            }, new int[][]{
                    {1, 3, 1},
                    {6, 0, 3},
                    {3, 3, 3}
            });
  }
}
