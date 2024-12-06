package dynamicProgramming.dpOnStrings;

import java.util.Arrays;

public class MinimumInsertionsDeletionsToConvertString {
    public static int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return n - lpsUtil(0, n-1, s, dp);
    }

    private static int lpsUtil(int low, int high, String s, int[][] dp) {
        if (low > high) return 0;
        if (low == high) return 1;

        if (dp[low][high] != -1) return dp[low][high];
        if (s.charAt(low) == s.charAt(high)) {
            dp[low][high] = 2 + lpsUtil(low+1, high-1, s, dp);
        }
        else {
            dp[low][high] = Math.max(lpsUtil(low+1, high, s, dp), lpsUtil(low, high-1, s, dp));
        }
        return dp[low][high];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println("Min insertions to make the string palindrome : " + minInsertions(s));
    }
}
