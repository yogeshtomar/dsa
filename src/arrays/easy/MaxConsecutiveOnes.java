package arrays.easy;

public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] array) {
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                count++;
            } else {
                count = 0;
            }
            maxCount = count > maxCount ? count : maxCount;
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 0, 1, 1, 1 };
        int ans = findMaxConsecutiveOnes(nums);
        System.out.println("The maximum consecutive ones are: " + ans);
    }
}
