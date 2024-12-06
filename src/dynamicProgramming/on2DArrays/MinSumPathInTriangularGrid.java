package dynamicProgramming.on2DArrays;

import java.util.Arrays;

public class MinSumPathInTriangularGrid {
    public static int minSum(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return minSumPathInTriangularGrid(triangle, 0, 0, n, dp);
    }
    private static int minSumPathInTriangularGrid(int[][] triangle, int i, int j, int N, int[][] dp) {
        if (i == N-1) {
            return dp[i][j] = triangle[i][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int down = triangle[i][j] + minSumPathInTriangularGrid(triangle, i+1, j, N, dp);
        int diagonal = triangle[i][j] + minSumPathInTriangularGrid(triangle, i+1, j+1, N, dp);

        return dp[i][j] = Math.min(down, diagonal);
    }

    public static int tabulation(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[n-1][j] = triangle[n-1][j];
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = triangle[i][j] + dp[i+1][j];
                int diagonal = triangle[i][j] + dp[i+1][j+1];

                dp[i][j] = Math.min(down, diagonal);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int triangle[][] = {{1},
                {2, 3},
                {3, 6, 7},
                {8, 9, 6, 10}};

        System.out.println("Min Path Sum: " + minSum(triangle));
        System.out.println("Min Path Sum tabulation: " + tabulation(triangle));
    }
}
