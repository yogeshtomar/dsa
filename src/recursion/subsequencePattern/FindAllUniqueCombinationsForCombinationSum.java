package recursion.subsequencePattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllUniqueCombinationsForCombinationSum {
    public static List<List<Integer>> combinationSum2(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(array);
        backtrack(array, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] array, int target, int index, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < array.length; i++) {
            if (i > index && array[i] == array[i-1]) {
                continue;
            }
            if (array[i] > target) {
                break;
            }
            current.add(array[i]);
            backtrack(array, target - array[i], i + 1, current, result);
            current.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        System.out.println("Combinations that sum to " + target + " : ");
        List<List<Integer>> result = combinationSum2(candidates, target);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
