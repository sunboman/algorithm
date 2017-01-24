package xwan.lintcode.array_and_numbers;

/**
 * Created by xwan on 11/29/16.
 */
public class best_time_to_buy_and_sell_stock_149 {
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
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            maxProf = Math.max(maxProf, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return maxProf;
    }

    public static void main(String[] args) {
        int[] prices = {3, 2, 3, 1, 2};

        int max = maxProfit(prices);

        System.out.println(max);
    }
}
