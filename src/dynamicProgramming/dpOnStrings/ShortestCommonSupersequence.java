package dynamicProgramming.dpOnStrings;

import java.util.Arrays;

public class ShortestCommonSupersequence {
    public static String shortestCommonSupersequence(String a, String b) {
        int m = a.length();
        int n = b.length();

        int[][] dp = new int[m+1][n+1];
        for (int[] row : dp) Arrays.fill(row, -1);

        longestCommonSubsequence(m-1, n-1, a, b, dp);
        return buildScs(a, b, dp);
    }

    private static int longestCommonSubsequence(int i, int j, String a, String b, int[][] dp) {
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return 1;

        if (a.charAt(i) == b.charAt(j)) {
            dp[i][j] = 1 + longestCommonSubsequence(i-1, j-1, a, b,dp);
        }
        else {
            dp[i][j] = Math.max(longestCommonSubsequence(i-1, j, a, b, dp),
                                longestCommonSubsequence(i,j-1, a, b, dp));
        }
        return dp[i][j];
    }

    private static String buildScs(String a, String b, int[][] dp) {
        StringBuilder scs = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;

        while (i >= 0 && j >= 0) {
            if (a.charAt(i) == b.charAt(j)) {
                scs.append(a.charAt(i));
                i--;
                j--;
            }
            else if (j == 0 || (i > 0 && dp[i-1][j] >= dp[i][j-1])){
                scs.append(a.charAt(i));
                i--;
            }
            else {
                scs.append(b.charAt(j));
                j--;
            }
        }
        while (i >= 0) scs.append(a.charAt(i--));
        while (j >= 0) scs.append(b.charAt(j--));

        return scs.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "abac";
        String b = "cab";

        String scs = shortestCommonSupersequence(a, b);
        System.out.println("Shortest Common Supersequence: " + scs);
    }
}
