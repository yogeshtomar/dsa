package dynamicProgramming.on2DArrays;

import java.util.Arrays;

public class NinjaTraining {
    public static int ninjaTraining(int n, int[][] points) {
        int[][] dp = new int[n][4];
        for (int[] it : dp) {
            Arrays.fill(it, -1);
        }
        return maxPoints(n-1, 3, points, dp);
    }

    private static int maxPoints(int day, int lastActivity, int[][] points, int[][] dp) {
        if (day == 0) {
            int maxPoints = 0;
            for (int activity = 0; activity < 3; activity++) {
                if (activity != lastActivity) {
                    maxPoints = Math.max(points[day][activity], maxPoints);
                }
            }
            return dp[day][lastActivity] = maxPoints;
        }

        if (dp[day][lastActivity] != -1) {
            return dp[day][lastActivity];
        }

        int maxPoints = 0;
        for (int activity = 0; activity < 3; activity++) {
            if (activity != lastActivity) {
                int activityPoints = points[day][activity] + maxPoints(day-1, activity, points, dp);
                maxPoints = Math.max(activityPoints, maxPoints);
            }
        }
        return dp[day][lastActivity] = maxPoints;
    }

    public static void main(String[] args) {
        int[][] points = {
                {10, 40, 70}, // Points for day 0
                {20, 50, 80}, // Points for day 1
                {30, 60, 90}  // Points for day 2
        };

        int n = points.length;
        System.out.println("Max points in Ninja Training : " + ninjaTraining(n, points));
        System.out.println(tabulation(n, points));
    }

    public static int tabulation(int days, int[][] points) {
        int[][] dp = new int[days][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < days; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        int activity = points[day][task] + dp[day-1][task];
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
        }
        return dp[days-1][3];
    }
}
