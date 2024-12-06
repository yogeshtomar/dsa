package recursion.subsequencePattern;


import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {
    public static List<List<Integer>> findSubsequencesWithSum(int[] array, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(array, k, 0, new ArrayList<>(), result);
        return result;
    }

    public static void backtrack(int[] array, int targetSum, int index, List<Integer> current, List<List<Integer>> result) {
        if (targetSum == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < array.length; i++) {
            if (array[i] <= targetSum) {
                current.add(array[i]);

                backtrack(array, targetSum - array[i], index, current, result);

                current.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 10;
        System.out.println("Subsequence with subset sum = " + sum);
        List<List<Integer>> result = findSubsequencesWithSum(array, sum);
        System.out.println(result.toString());
        System.out.println("Result Size: " + result.size());
    }
}
