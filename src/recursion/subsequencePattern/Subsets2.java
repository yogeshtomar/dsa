package recursion.subsequencePattern;

import java.util.*;

public class Subsets2 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        getPowerset(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void getPowerset(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i-1]) {
                continue;
            }
            current.add(nums[i]);
            getPowerset(nums, i + 1, current, result);
            current.removeLast();
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = subsetsWithDup(nums);
        System.out.println(result);
    }
}
