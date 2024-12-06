package arrays.easy;

public class LargestElementInArray {
    public static int largestElement(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int item : array) {
            max = item > max ? item : max;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {2,5,1,3,0};
        System.out.println("Max element: " + largestElement(array));
        int[] array2 = {8,10,5,7,9};
        System.out.println("Max element: " + largestElement(array2));
    }
}
