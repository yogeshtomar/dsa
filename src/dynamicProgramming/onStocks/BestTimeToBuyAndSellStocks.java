package dynamicProgramming.onStocks;

/**
 * Best time to buy and sell stock
 * We are given an array Arr[] of length n. It represents the price of a stock on ‘n’ days. The following guidelines need to be followed:
 * We can buy and sell a stock only once.
 * We can buy and sell the stock on any day but to sell the stock, we need to first buy it on the same or any previous day.
 * We need to tell the maximum profit one can get by buying and selling this stock.
 */

public class BestTimeToBuyAndSellStocks {
    public static int maximumProfit(int[] array) {
        int maxProfit = 0;
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            int curProfit = array[i] - min;
            maxProfit = Math.max(maxProfit, curProfit);
            min = Math.min(min, array[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println("The max profit by selling the stock is : " + maximumProfit(prices));
    }
}
