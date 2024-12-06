package dynamicProgramming.dpOnStrings;

import java.util.Arrays;

public class WildcardMatching {
    private static boolean isAllStars(String s1, int i) {
        for (int j = 0; j <= i; j++) {
            if (s1.charAt(j) != '*') {
                return false;
            }
        }
        return true;
    }
    public static int wildcardMatching(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return wildcardMatchingUtil(m-1, n-1, s1, s2, dp);
    }

    private static int wildcardMatchingUtil(int i, int j, String s1, String s2, int[][] dp) {
        if (i < 0 && j < 0) {
            return 1;
        }
        if (i < 0 && j >= 0) {
            return 0;
        }
        if (j < 0 && i >= 0) {
            return isAllStars(s1, i) ? i : 0;
        }
        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?') {
            return dp[i][j] = wildcardMatchingUtil(i-1, j-1, s1, s2, dp);
        }
        else {
            if (s1.charAt(i) == '*') {
                return dp[i][j] = (wildcardMatchingUtil(i-1, j, s1, s2, dp) == 1 || wildcardMatchingUtil(i, j-1, s1, s2, dp) == 1) ? 1: 0;
            }
            else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        String S1 = "ab*cd";
        String S2 = "abdefcd";

        if (wildcardMatching(S1, S2) == 1)
            System.out.println("String S1 and S2 do match");
        else
            System.out.println("String S1 and S2 do not match");
    }
}
