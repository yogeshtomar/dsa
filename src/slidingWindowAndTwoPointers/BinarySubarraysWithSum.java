package slidingWindowAndTwoPointers;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {
    public int subarraysWithSum(int[] arr, int S) {
        int sum = 0, ans = 0;
        int left = 0, right = 0;

        while (right < arr.length) {
            sum += arr[right];

            while (sum > S) {
                sum = sum - arr[left++];
            }
            ans = (right - left) + 1;
            right++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        BinarySubarraysWithSum sol = new BinarySubarraysWithSum();
        System.out.println("Number of Subarrays with Sum : " + goal + " are : " + sol.subarraysWithSum(nums, goal));
    }

}
