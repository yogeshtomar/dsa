package dynamicProgramming.dpOnStrings;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
    public static int lps(String str) {
        int n = str.length();
        int low = 0, high = str.length()-1;
        int[][] dp = new int[n+1][n+1];

        for (int[] row : dp) Arrays.fill(row, -1);

        return lpsUtil(low, high, str, dp);
    }

    private static int lpsUtil(int low, int high, String str, int[][] dp) {
        if (high < low) {
            return 0;
        }
        if (low == high) {
            return 1;
        }

        if (dp[low][high] != -1) {
            return dp[low][high];
        }

        if (str.charAt(low) == str.charAt(high)) {
            return dp[low][high] = 2 + lpsUtil(low+1, high-1, str, dp);
        }
        else {
            return dp[low][high] = Math.max(lpsUtil(low+1, high, str, dp), lpsUtil(low, high-1, str, dp));
        }
    }

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(lps(s));
    }
}
