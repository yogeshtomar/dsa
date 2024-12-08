package dynamicProgramming.onStocks;

import java.util.Arrays;

/**
 *  We are given an array Arr[] of length n. It represents the price of a stock on ‘n’ days. The following guidelines
 *  need to be followed:
 *  We can buy and sell the stock any number of times.
 *  In order to sell the stock, we need to first buy it on the same or any previous day.
 *  We can’t buy a stock again after buying it once. In other words, we first buy a stock and then sell it. After
 *  selling we can buy and sell again. But we can’t sell before buying and can’t buy before selling any previously
 *  bought stock.
 *  We can’t buy a stock on the very next day of selling it. This is the cooldown clause.
 */

public class BuyAndSellStockWithCooldown {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2]; // dp[i][0]: max profit without stock, dp[i][1]: max profit with stock
        for (int[] row : dp) Arrays.fill(row, -1);

        return maxProfitHelper(0, 0, prices, dp);
    }

    private static int maxProfitHelper(int index, int holding, int[] prices, int[][] dp) {
        if (index >= prices.length) return 0; // No more days to trade

        if (dp[index][holding] != -1) return dp[index][holding];

        // Skip the current day
        int skip = maxProfitHelper(index + 1, holding, prices, dp);

        if (holding == 1) {
            // If holding a stock, we can sell it
            int sell = prices[index] + maxProfitHelper(index + 2, 0, prices, dp);
            System.out.println("Sell price : " + prices[index] + " at day : " + (index+1));
            dp[index][holding] = Math.max(skip, sell);
        } else {
            // If not holding a stock, we can buy one
            int buy = -prices[index] + maxProfitHelper(index + 1, 1, prices, dp);
            System.out.println("Buy price : " + prices[index] + " at day : " + (index+1));
            dp[index][holding] = Math.max(skip, buy);
        }

        return dp[index][holding];
    }

    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        System.out.println("Maximum Profit: " + maxProfit(prices)); // Output: 3
    }
}
