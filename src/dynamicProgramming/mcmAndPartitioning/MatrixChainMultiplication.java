package dynamicProgramming.mcmAndPartitioning;

import java.util.Arrays;

public class MatrixChainMultiplication {
    public static int matrixMultiplication(int[] array) {
        int n = array.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int i = 1;
        int j = n-1;

        return helper(i, j, array, dp);
    }

    private static int helper(int i, int j, int[] array, int[][] dp) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j-1; k++) {
            int ans = helper(i, k, array, dp) + helper(k+1, j, array, dp) + array[i-1] * array[k] * array[j];
            min = Math.min(min, ans);
        }
        return min;
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};
        System.out.println("The min number of operations are: " + matrixMultiplication(array));
    }

}
