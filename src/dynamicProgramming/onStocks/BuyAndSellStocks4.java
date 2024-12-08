package dynamicProgramming.onStocks;

import java.util.Arrays;

public class BuyAndSellStocks4 {
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k+1];

        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }

        return maxProfitUtil(0, 0, k, prices, dp);
    }

    private static int maxProfitUtil(int idx, int holding, int k, int[] prices, int[][][] dp) {
        if (idx == prices.length || k == 0) {
            return 0;
        }
        if (dp[idx][holding][k] != -1) {
            return dp[idx][holding][k];
        }

        int skip = maxProfitUtil(idx+1, holding, k, prices, dp);
        // if we are holding stocks then we can sell them
        if (holding == 1) {
            int sell = prices[idx] + maxProfitUtil(idx+1, 0, k-1, prices, dp);
            dp[idx][holding][k] = Math.max(sell, skip);
        }
        else {
            // we are not holding any stock so we should buy them
            int buy = -prices[idx] + maxProfitUtil(idx+1, 1, k, prices, dp);
            dp[idx][holding][k] = Math.max(buy, skip);
        }
        return dp[idx][holding][k];
    }

    public static void main(String[] args) {
        // k = 2, prices = [3,2,6,5,0,3]
        int[] prices = {3,2,6,5,0,3};
        int k = 2;
        System.out.println("Maximum profit that can be earned is : " + maxProfit(k, prices));
    }
}
