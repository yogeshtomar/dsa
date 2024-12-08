package dynamicProgramming.mcmAndPartitioning;

public class MatrixChainMultiplicationTabulation {
    public static int matrixChainMultiplication(int[] dimensions) {
        int n = dimensions.length;
        int[][] dp = new int[n][n]; // dp[i][j] stores the minimum cost to multiply matrices from i to j

        // Base case: Single matrix cost is 0 (diagonal elements remain 0)
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // Fill the dp table in a bottom-up manner
        for (int length = 2; length < n; length++) { // length is the chain length
            for (int i = 1; i < n - length + 1; i++) {
                int j = i + length - 1;
                dp[i][j] = Integer.MAX_VALUE;

                // Try all possible partitions
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + dimensions[i - 1] * dimensions[k] * dimensions[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[1][n - 1]; // Minimum cost to multiply matrices from 1 to n-1
    }

    public static void main(String[] args) {
        int[] dimensions = {10, 20, 30, 40, 30}; // Example matrix dimensions
        int minCost = matrixChainMultiplication(dimensions);
        System.out.println("Minimum cost of multiplying matrices: " + minCost);
    }
}
