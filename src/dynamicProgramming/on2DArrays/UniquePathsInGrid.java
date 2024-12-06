package dynamicProgramming.on2DArrays;

import java.util.Arrays;

public class UniquePathsInGrid {
    public static int totalUniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return uniquePathsHelper( 0, 0, dp, m, n);
    }

    private static int uniquePathsHelper(int row, int col, int[][] dp, int m, int n) {
        if (row == m-1 && col == n-1) {
            return 1;
        }
        if (row > m || col > n) {
            return 0;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int right =  uniquePathsHelper(row,col+1, dp, m, n);
        int bottom = uniquePathsHelper(row+1, col, dp, m, n);

        return dp[row][col] = right + bottom;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 2;

        System.out.println(STR."No of ways: \{totalUniquePaths(m, n)}");
        System.out.println(STR."No of ways tabulation: \{tabulation(m, n)}");
    }

    public static int tabulation(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
