package dynamicProgramming.on2DArrays;

import java.util.Arrays;
import java.util.Map;

public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m+1][n+1];
        for (int[] it : dp) {
            Arrays.fill(it, -1);
        }

        return minPathSumUtil(grid, 0, 0, dp, m, n);
    }

    private static int minPathSumUtil(int[][] grid, int row, int col, int[][]dp, int m, int n) {
        if (row == m-1 && col == n-1) {
            return dp[row][col] = grid[row][col];
        }

        if (row >= m || col >= m) {
            return (int) Math.pow(10, 9);
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int down = grid[row][col] + minPathSumUtil(grid, row+1, col, dp, m, n);
        int right = grid[row][col] + minPathSumUtil(grid, row, col+1, dp, m, n);

        return dp[row][col] = Math.min(down, right);
    }

    private static int tabulation(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = maze[i][j];
                }
                else {
                    int down = maze[i][j];
                    down += i > 0 ?  dp[i-1][j] : (int) Math.pow(10, 9);

                    int right = maze[i][j];
                    right += j > 0 ? dp[i][j-1] : (int) Math.pow(10, 9);
                    dp[i][j] = Math.min(down, right);
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {5, 9, 6},
                {11, 5, 2}
        };

        System.out.println(STR."Min Path Sum : \{minPathSum(matrix)}");
        System.out.println(STR."Min Path Sum tabulation: \{tabulation(matrix)}");
    }
}
