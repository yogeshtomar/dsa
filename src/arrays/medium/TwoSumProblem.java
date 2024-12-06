package arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {
    public static int[] twoSum(int[] array, int target) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (map.containsKey(target - num)) {
                ans[0] = i;
                ans[1] = map.get(target - num);
                return ans;
            }
            map.put(array[i], i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;
        int[] ans = twoSum(arr, target);
        System.out.println("2 Sum Pair: " + arr[ans[0]] + " + " + arr[ans[1]] + " = " + target);
    }
}
