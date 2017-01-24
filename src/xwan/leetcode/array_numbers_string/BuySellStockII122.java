package xwan.leetcode.array_numbers_string;

/**
 * Created by xwan on 12/26/16.
 */
public class BuySellStockII122 {
    // solution with greedy
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int max_profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max_profit += prices[i] + prices[i - 1];
            }
        }
        return max_profit;
    }
}
