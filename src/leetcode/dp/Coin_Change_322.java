package leetcode.dp;

import java.util.Arrays;

/**
 * Created by sunbo_000 on 10/21/2016.
 */

/*
    https://leetcode.com/problems/coin-change/
    You are given coins of different denominations and a total amount of money amount. Write a function to compute the
    fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any
    combination of the coins, return -1.

    Example 1:
    coins = [1, 2, 5], amount = 11
    return 3 (11 = 5 + 5 + 1)

    Example 2:
    coins = [2], amount = 3
    return -1.

    Note:
    You may assume that you have an infinite number of each kind of coin.
 */
public class Coin_Change_322 {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        long[] dp = new long[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int coin : coins) {
            if (coin <= amount) dp[coin] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }


        return dp[amount] >= Integer.MAX_VALUE ? -1 : (int) dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Coin_Change_322().coinChange(new int[]{1}, 0));
    }

}
