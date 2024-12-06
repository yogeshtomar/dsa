package arrays.easy;

public class MissingNumberInAnArray {
    public static int missingNumber(int[] array, int n) {
        int sum = (n * (n+1)) / 2;
        int sum2 = 0;
        for (int i = 0; i < n-1; i++) {
            sum2 += array[i];
        }
        int missingNo = sum - sum2;
        return missingNo;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] array = {1, 2, 4, 5};
        System.out.println("The missing number is:" + missingNumber(array, n));
    }
}
