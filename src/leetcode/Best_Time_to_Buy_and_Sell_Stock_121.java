package leetcode;

/**
 * Created by sunbo_000 on 10/13/2016.
 */

/*
    https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class Best_Time_to_Buy_and_Sell_Stock_121 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int[] priceChanges = new int[prices.length - 1];
        for (int i = 0; i < priceChanges.length; i++) {
            priceChanges[i] = prices[i + 1] - prices[i];
        }
        int max = 0;
        int currMax = 0;
        for (int i = 0; i < priceChanges.length; i++) {

            currMax += priceChanges[i];
            max = Math.max(max, currMax);
            if (currMax < 0) currMax = 0;
        }

        return max;
    }

    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock_121 solution = new Best_Time_to_Buy_and_Sell_Stock_121();
        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
