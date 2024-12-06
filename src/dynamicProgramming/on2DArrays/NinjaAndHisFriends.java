package dynamicProgramming.on2DArrays;

import java.util.Arrays;

public class NinjaAndHisFriends {
    public static int maxChocolates(int n, int m, int[][] grid) {
        int[][][] dp = new int[n][m][m];

        for (int[][] layer  : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }
        return findMaxChocolates(0, 0, m-1, grid, n, m, dp);
    }

    private static int findMaxChocolates(int i, int j1, int j2, int[][] grid, int n, int m, int[][][] dp) {
        if (j1 < 0 || j1 >= m || j1 < 0 || j2 >= m) {
            return Integer.MIN_VALUE;
        }

        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }

        if (i == n-1) {
            if (j1 == j2) {
                return grid[i][j1];
            }
            else {
                return grid[i][j1] + grid[i][j2];
            }
        }

        int maxChocolates = Integer.MIN_VALUE;

        for (int move1 = -1; move1 <= 1; move1++) {
            for (int move2 = -1; move2 <= 1; move2++) {
                int nextCol1 = j1 + move1;
                int nextCol2 = j2 + move2;

                int value = findMaxChocolates(i + 1, nextCol1, nextCol2, grid, n, m, dp);
                if (j1 == j2) {
                    value += grid[i][j1];
                }
                else {
                    value += grid[i][j1] + grid[i][j2];
                }
                maxChocolates = Math.max(maxChocolates, value);
            }
        }
        return dp[i][j1][j2] = maxChocolates;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}
        };

        int n = grid.length;
        int m = grid[0].length;

        System.out.println("Maximum Chocolates Collected: " + maxChocolates(n, m, grid));
    }
}
