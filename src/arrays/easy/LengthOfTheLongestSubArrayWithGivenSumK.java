package arrays.easy;

public class LengthOfTheLongestSubArrayWithGivenSumK {
    public static int getLongestSubArrayLength(int[] array, int k) {
        int left = 0, right = 0;
        int sum = array[0];
        int maxLen = 0;

        while (right < array.length){
            while (left <= right && sum > k) {
                sum = sum - array[left];
                left++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            sum = sum + array[right];
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 5, 1, 9};
        int k = 10;
        int len = getLongestSubArrayLength(a, k);
        System.out.println("Length of the longest subarray: " + len);
    }
}
