package arrays.medium;

import java.util.Arrays;

public class TwoSumUsingSorting {
    public static int[] twoSumUsingSorting(int[] array, int target) {
        Arrays.sort(array);
        int[] ans = {-1, -1};
        int left = 0, right = array.length - 1;
        while (left < right) {
            int sum = array[left] + array[right];
            if (sum == target) {
                return new int[] {left, right};
            }
            else if (sum < target) {
                left++;
            }
            else {
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;
        int[] ans = twoSumUsingSorting(arr, target);
        System.out.println("2 Sum Pair: " + arr[ans[0]] + " + " + arr[ans[1]] + " = " + target);
    }
}
