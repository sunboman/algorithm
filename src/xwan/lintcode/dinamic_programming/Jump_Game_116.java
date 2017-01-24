package xwan.lintcode.dinamic_programming;

/**
 * Created by xwan on 10/31/16.
 */

/**
 * 116 Jump Game
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

     Each element in the array represents your maximum jump length at that position.

     Determine if you are able to reach the last index.

     Notice

     This problem have two method which is Greedy and Dynamic Programming.

     The time complexity of Greedy method is O(n).

     The time complexity of Dynamic Programming method is O(n^2).

     We manually set the small data set to allow you pass the test in both ways. This is just to let you learn how to use this problem in dynamic programming ways. If you finish it in dynamic programming ways, you can try greedy method to make it accept again.

     Have you met this question in a real interview? Yes
     Example
     A = [2,3,1,1,4], return true.

     A = [3,2,1,0,4], return false.
 *
 * http://www.lintcode.com/en/problem/jump-game/
 */
public class Jump_Game_116 {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    // solution with dp
     public boolean canJump_dp(int[] A) {
         int n = A.length;
         if (A == null || n == 0) {
             return false;
         }

         boolean[] dp = new boolean[n + 1];
         dp[0] = true;

         for (int i = 1; i < n; i++) {
             for (int j = 0; j < i; j++) {
                 if (dp[j] && j + A[j] >= i) {
                     dp[i] = true;
                     break;
                 }
             }
         }

         return dp[n - 1];
     }

    // solution with greedy
    public boolean canJump_greedy(int[] A) {
        int len = A.length;
        if (A == null || len == 0) {
            return false;
        }

        int maxFar = A[0];
        for (int i = 1; i < len; i++) {
            // check the farthest it can be and record the farthest position
            if (maxFar >= i && i + A[i] > maxFar) {
                maxFar = i + A[i];
            }
        }

        return maxFar >= len - 1;
    }
}
