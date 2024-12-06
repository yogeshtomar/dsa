package dynamicProgramming.on2DArrays;

import java.util.Arrays;

public class GridUniquePaths {
    public static int noOfWays(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;

        int[][] dp = new int[m+1][n+1];
        for (int[] it : dp) {
            Arrays.fill(it, -1);
        }

        return countNoOfWays(maze, 0, 0, dp, m, n);
    }

    private static int countNoOfWays(int[][] maze, int row, int col, int[][] dp, int m, int n) {
        if (row == m-1 && col == n-1) {
            return 1;
        }
        if (row > m || col > n) {
            return 0;
        }
        if (row < m && col < n && maze[row][col] == -1) {
            return 0;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        int right = countNoOfWays(maze, row, col + 1, dp, m, n);
        int bottom = countNoOfWays(maze, row + 1, col, dp, m, n);

        return dp[row][col] = right + bottom;
    }

    private static int tabulation(int[][] maze) {
        int m = maze.length;;
        int n = maze[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0 && maze[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                int right = 0;
                int bottom = 0;

                if (i > 0) {
                    bottom = dp[i-1][j];
                }
                if (j > 0) {
                    right = dp[i][j-1];
                }
                dp[i][j] = right + bottom;
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 0},
                {0, -1, 0},
                {0, 0, 0}
        };

        System.out.println(noOfWays(maze));
        System.out.println(tabulation(maze));
    }
}
