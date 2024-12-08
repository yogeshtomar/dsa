package dynamicProgramming.onLIS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreaingSubsequenceBinarySearch {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int len = 0;
        dp[len++] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > dp[len-1]) {
                dp[len++] = nums[i];
            }
            else {
                int index = binarSearch(dp, 0, len-1, nums[i]);
                dp[index] = nums[i];
            }
        }
        return len;
    }

    private static int binarSearch(int[] nums, int low, int high, int key) {
        int mid = 0;
        while (low <= high) {
            mid = low + (high-low)/2;
            if (nums[mid] == key) {
                return mid;
            }
            else if (key < nums[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of Longest Increasing Subsequence: " + lengthOfLIS(nums)); // Output: 4
    }
}
