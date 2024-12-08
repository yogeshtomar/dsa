package dynamicProgramming.mcmAndPartitioning;

import java.util.Arrays;

public class MinCostToCutTheStick {
    public static int minCost(int n, int[] cuts) {
        // Include 0 and n as boundaries of the stick
        int[] allCuts = new int[cuts.length + 2];
        allCuts[0] = 0;
        allCuts[allCuts.length - 1] = n;

        // Copy cuts and sort the array
        for (int i = 0; i < cuts.length; i++) {
            allCuts[i + 1] = cuts[i];
        }
        Arrays.sort(allCuts);

        // Memoization table
        int[][] memo = new int[allCuts.length][allCuts.length];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return findMinCost(1, allCuts.length - 2, allCuts, memo);
    }

    private static int findMinCost(int left, int right, int[] allCuts, int[][] memo) {
        // Base case: no cuts to make
        if (left > right) {
            return 0;
        }

        // If already computed, return the stored value
        if (memo[left][right] != -1) {
            return memo[left][right];
        }

        int minCost = Integer.MAX_VALUE;

        // Try making a cut at each position between left and right
        for (int i = left; i <= right; i++) {
            int cost = allCuts[right + 1] - allCuts[left - 1]; // Cost of the current segment
            cost += findMinCost(left, i - 1, allCuts, memo) + findMinCost(i + 1, right, allCuts, memo);
            minCost = Math.min(minCost, cost);
        }

        // Store the result in memo table
        memo[left][right] = minCost;
        return minCost;
    }

    public static void main(String[] args) {
        int n = 7;
        int[] cuts = {1, 3, 4, 5};
        System.out.println("Minimum cost to cut the stick: " + minCost(n, cuts));
    }
}
