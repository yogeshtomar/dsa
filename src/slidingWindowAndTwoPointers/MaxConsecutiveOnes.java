package slidingWindowAndTwoPointers;

public class MaxConsecutiveOnes {
    public static int longestOnes(int[] A, int K) {
        int start = 0, end = 0;
        int zeros = 0;
        while (end < A.length) {
            if (A[end] == 0) {
                zeros++;
            }
            while (zeros > K) {
                if (A[start] == 0) {
                    zeros--;
                }
                start++;
            }
            end++;
        }
        return end - start;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        System.out.println("Maximum consecutive ones with at most " + k + " flips: " + longestOnes(nums, k));
    }
}
