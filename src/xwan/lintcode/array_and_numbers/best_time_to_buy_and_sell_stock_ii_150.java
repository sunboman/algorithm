package xwan.lintcode.array_and_numbers;

/**
 * Created by xwan on 11/29/16.
 */
public class best_time_to_buy_and_sell_stock_ii_150 {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public static int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int maxProf = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            if (diff > 0) {
                maxProf += diff;
            }
        }

        return maxProf;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 4}; // {2, 1, 2, 0, 1}

        int max = maxProfit(prices);

        System.out.println(max);
    }

}
