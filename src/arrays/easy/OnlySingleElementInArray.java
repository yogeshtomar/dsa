package arrays.easy;

public class OnlySingleElementInArray {
    public static int findSingleElement(int[] array) {
        int xor = 0;
        for (int a : array) {
            xor = xor ^ a;
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 1, 2};
        int ans = findSingleElement(arr);
        System.out.println("The single element is: " + ans);
    }
}
