package dynamicProgramming.on1DArrays;

import java.util.Arrays;

public class MaxSumOfNonAdjacentElements {
    private static int maxSumHelper(int index, int[] array, int[] dp) {
        if (index == 0) {
            return array[index];
        }

        if (index < 0) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int pick = array[index] + maxSumHelper(index - 2, array, dp);
        int notPick = maxSumHelper(index-1, array, dp);

        return dp[index] = Math.max(pick, notPick);
    }

    private static int maxSum(int n, int[] array) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return maxSumHelper(n-1, array, dp);
    }

    public static void main(String[] args) {
        int[] array = {2, 1, 4, 9};
        System.out.println("Max Sum : " + maxSum(array.length, array));
        System.out.println("Max Sum Tabulation: " + tabulation(array.length, array));
    }

    private static int tabulation(int n, int[] array) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, 0   );;

        dp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            int pick = array[i];
            if (i > 1) {
                pick += dp[i-2];
            }
            int notPick = dp[i-1];
            dp[i] = Math.max(pick, notPick);
        }

        return dp[n-1];
    }
}
