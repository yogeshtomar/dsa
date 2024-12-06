package dynamicProgramming.on2DArrays;

import java.util.Arrays;

public class MinMaxFallingPathSum {
    private static int getMaxUtil(int[][] grid, int i, int j, int m, int[][] dp) {
        if (j < 0 || j >= m) {
            return (int) Math.pow(-10, 9);
        }
        if (i == 0) {
            return grid[0][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = grid[i][j] + getMaxUtil(grid, i-1, j, m, dp);
        int leftDiagonal = grid[i][j] + getMaxUtil(grid, i-1, j-1, m, dp);
        int rightDiagonal = grid[i][j] + getMaxUtil(grid, i-1, j+1, m, dp);

        return dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
    }

    private static int tabulation(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = grid[i][j] + dp[i-1][j];

                int leftDiagonal = grid[i][j];
                leftDiagonal += j - 1 >= 0 ? dp[i-1][j-1] : (int) Math.pow(-10, 9);

                int rightDiagonal = grid[i][j];
                rightDiagonal += j + 1 < n ? dp[i-1][j+1] : (int) Math.pow(-10, 9);

                dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
            }
        }
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            max = Math.max(max, dp[m-1][j]);
        }
        return max;
    }

    public static int getMaxPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            int ans = getMaxUtil(grid, m-1, j, m, dp);
            max = Math.max(max, ans);
        }
        return max;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1}};
        System.out.println("Max Path Sum: " + getMaxPathSum(matrix));
        System.out.println("Max Path Sum: " + tabulation(matrix));
    }
}
