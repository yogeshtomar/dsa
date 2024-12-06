package dynamicProgramming.dpOnStrings;

import java.util.Arrays;

/**
 * We are given two strings S1 and S2, we want to know how many distinct subsequences of S2 are present in S1.
 */
public class DistinctSubsequence {
    private static int prime = (int) (Math.pow(10, 9) + 7);

    private static int countUtil(int i, int j, String a, String b, int[][] dp) {
        if (i < 0) {
            return 1;
        }
        if (j < 0) {
            return 0;
        }

        if (dp[i][j] != -1){
            return dp[i][j];
        }

        if (a.charAt(i) == b.charAt(j)) {
            int leaveOne = countUtil(i-1, j-1, a, b, dp);
            int stay = countUtil(i-1, j, a, b, dp);

            return dp[i][j] = (leaveOne + stay) % prime;
        }
        else {
            return dp[i][j] = countUtil(i-1, j, a, b, dp);
        }
    }

    public static int subsequenceCounting(String a, String b) {
        int m = a.length();
        int n = b.length();

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return countUtil(m-1, n-1, a, b, dp);
    }

    public static void main(String[] args) {
        String a = "babgbag";
        String b = "bag";

        System.out.println("The count of Distinct Subsequences is : " + subsequenceCounting(a, b));
    }
}
