package dynamicProgramming.dpOnStrings;

import java.util.Arrays;
import java.util.Map;

public class LongestCommonSubstring {
    public static int longestCommonSubstring(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[n+1][m+1];
        for (int[] row : dp) Arrays.fill(row, -1);
        int[] maxLength = {0};
        longestCommonSubstringUtil(m-1, n-1, s1, s2, 0, maxLength,dp);
        return maxLength[0];
    }

    private static int longestCommonSubstringUtil(int idx1, int idx2, String s1, String s2, int curLength, int[] maxLength,int[][] dp) {
        if (idx1 < 0 || idx2 < 0) {
            return 0;
        }
        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }
        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            curLength = 1 + longestCommonSubstringUtil(idx1-1, idx2-1, s1, s2, curLength, maxLength, dp);
            maxLength[0] = Math.max(maxLength[0], curLength);
        }
        else {
            curLength = 0;
        }
        dp[idx1][idx2] = curLength;
        longestCommonSubstringUtil(idx1-1, idx2, s1, s2, 0, maxLength, dp);
        longestCommonSubstringUtil(idx1, idx2-1, s1, s2,0, maxLength, dp);
        return dp[idx1][idx2];
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = " abfce";

        int result = longestCommonSubstring(s1, s2);
        System.out.println("Length of the longest common substring: " + result);
        System.out.println("Length of the longest common substring using tabulation is : " + tabulation(s1, s2));
    }

    private static int tabulation(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    int val = 1 + dp[i-1][j-1];
                    dp[i][j] = val;
                    ans = Math.max(ans, val);
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
}
