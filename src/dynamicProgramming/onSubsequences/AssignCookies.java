package dynamicProgramming.onSubsequences;

import java.util.Arrays;

public class AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length;
        int m = s.length;
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(g, s, 0, 0, dp);
    }

    private static int helper(int[] g, int[] s, int childIdx, int cookieIdx, int[][] dp) {
        if (childIdx >= g.length || cookieIdx >= s.length) {
            return 0;
        }

        if (dp[childIdx][cookieIdx] != -1) {
            return dp[childIdx][cookieIdx];
        }

        int assign = 0;
        if (s[cookieIdx] >= g[childIdx]) {
            assign = 1 + helper(g, s, childIdx+1, cookieIdx+1, dp);
        }
        int skip = helper(g, s, childIdx, cookieIdx+1, dp);

        return dp[childIdx][cookieIdx] = Math.max(assign, skip);
    }

    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println("Max no of content children = " + findContentChildren(g, s));
        System.out.println("Max no of cpntent children Tabulation : " + tabulation(g, s));
    }

    public static int tabulation(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int n = g.length;
        int m = s.length;

        int[][] dp = new int[n+1][m+1];

        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                int assign = 0;
                if (s[j] >= g[i]) {
                    assign = 1 + dp[i+1][j+1];
                }
                int skip = dp[i][j+1];
                dp[i][j] = Math.max(assign, skip);
            }
        }
        return dp[0][0];
    }
}
