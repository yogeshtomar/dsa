package recursion.subsequencePattern;

public class CountAllSubsequencesWithSumK {
    public static int countSubsequences(int[] array, int k) {
        return countSubsequencesHelper(array, k, 0, 0);
    }

    private static int countSubsequencesHelper(int[] array, int k, int index, int currentSum) {
        if (index == array.length) {
            return currentSum == k ? 1 : 0;
        }

        int include = countSubsequencesHelper(array, k, index+1, currentSum + array[index]);
        int exclude = countSubsequencesHelper(array, k, index+1, currentSum);

        return include + exclude;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 1, 3, 5};
        int k = 6;
        System.out.println("The number of subsequences with sum = " + k + " are : " + countSubsequences(array, k));
    }
}
