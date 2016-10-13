package leetcode.greedy;

/**
 * Created by sunbo_000 on 10/12/2016.
 */

/*
    https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class Best_Time_to_Buy_and_Sell_Stock_II_122 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int total_profit = 0;
        int start = 0;
        for(int i=1;i<prices.length;i++) {
            if(prices[i-1] > prices[i]) {
                total_profit += prices[i-1] - prices[start];
                start = i;
            }
        }

        total_profit+= prices[prices.length-1] - prices[start];

        return total_profit;
    }

    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock_II_122 solution = new Best_Time_to_Buy_and_Sell_Stock_II_122();
        solution.maxProfit(new int[]{1,2});
    }
}
