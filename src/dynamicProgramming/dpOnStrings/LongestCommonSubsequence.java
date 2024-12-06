package dynamicProgramming.dpOnStrings;

import java.util.Arrays;

/**
 * A subsequence of a string is a list of characters of the string where some characters are deleted
 * ( or not deleted at all) and they should be in the same order in the subsequence as in the original string.
 */
public class LongestCommonSubsequence {
    public static int lcsUtil(int idx1, int idx2, String s1, String s2, int[][] dp) {
        if (idx1 < 0 || idx2 < 0) {
            return 0;
        }

        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }

        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            return dp[idx1][idx2] = 1 + lcsUtil(idx1-1, idx2-1, s1, s2, dp);
        }

        else {
            return dp[idx1][idx2] = Math.max(lcsUtil(idx1-1, idx2, s1, s2, dp),
                                            lcsUtil(idx1, idx2-1, s1, s2, dp));
        }
    }

    public static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2. length();

        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return lcsUtil(m-1, n-1, s1, s2, dp);
    }

    public static void main(String[] args) {
        String s1 = "acd";
        String s2 = "ced";
        System.out.println("The length of the Longest Common Subsequence is : " + lcs(s1, s2));
        System.out.println("The length of the Longest Common Subsequence using tabulation is : " + tabulation(s1, s2));
    }

    private static int tabulation(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
