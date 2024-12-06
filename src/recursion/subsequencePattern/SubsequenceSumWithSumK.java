package recursion.subsequencePattern;

import java.util.ArrayList;
import java.util.List;

// check if there exist a subsequence with sum K
public class SubsequenceSumWithSumK {
    public static List<List<Integer>> findSubsequencesWithSum(int[] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsequences(arr, 0, new ArrayList<>(), 0, k, result);
        return result;
    }

    private static void generateSubsequences(int[] arr, int index, List<Integer> current, int currentSum, int targetSum, List<List<Integer>> result) {
        // Base case: when index reaches the end of the array
        if (index == arr.length) {
            if (currentSum == targetSum) {
                result.add(new ArrayList<>(current)); // Add a copy of current to the result
            }
            return;
        }

        // Include the current element in the subsequence
        current.add(arr[index]);
        generateSubsequences(arr, index + 1, current, currentSum + arr[index], targetSum, result);

        // Backtrack and exclude the current element from the subsequence
        current.remove(current.size() - 1);
        generateSubsequences(arr, index + 1, current, currentSum, targetSum, result);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 5};
        int k = 6;

        List<List<Integer>> result = findSubsequencesWithSum(arr, k);
        System.out.println(result.toString());
        System.out.println("Subsequence with sum: " + k + " found : " + (result.size() > 0 ? true : false));
    }
}
