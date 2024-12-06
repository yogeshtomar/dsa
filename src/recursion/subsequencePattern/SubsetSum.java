package recursion.subsequencePattern;

public class SubsetSum {
    public static int subsetSum(int[] array) {
        return findSubsetSum(array, 0, 0);
    }

    private static int findSubsetSum(int[] array, int index, int currentSum) {
        if (index == array.length) {
//            System.out.println(currentSum);
            return currentSum;
        }

        int includeSum = findSubsetSum(array, index + 1, currentSum + array[index]);

        int excludeSum = findSubsetSum(array, index + 1, currentSum);

        return includeSum + excludeSum;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        System.out.println(subsetSum(array));
    }
}
