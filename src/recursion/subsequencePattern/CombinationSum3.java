package recursion.subsequencePattern;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(1, k, n, new ArrayList<>(), result);
        return result;
    }

    private static void generateSubsets(int start, int k, int target, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k && target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (current.size() > k || target < 0) {
            return;
        }
        for (int i = start; i < 9; i++) {
            current.add(i);
            generateSubsets(i+1, k,target - i, current, result);
            current.removeLast();
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 7;

        List<List<Integer>> result = combinationSum3(k, n);
        System.out.println(result);
    }
}
