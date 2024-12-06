package slidingWindowAndTwoPointers;

public class CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] arr, int k) {
        return helper(arr, k) - helper(arr, k - 1);
    }

    private int helper(int[] nums, int k) {
        int left = 0, right = 0;
       int result = 0;

        while (right < nums.length) {
            if (nums[right] % 2 != 0) {
                k--;
            }

            while (k < 0) {
                if (nums[left++] % 2 != 0) {
                    k++;
                }
            }
            result += (right - left + 1);
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        CountNumberOfNiceSubarrays solver = new CountNumberOfNiceSubarrays();
        System.out.println("Number of nice subarrays with " + k + " odd numbers: " + solver.numberOfSubarrays(nums, k));
    }
}
