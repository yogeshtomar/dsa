package arrays.easy;

public class LargeAndSecondLarge {
    public static void largestAndSecondLargest(int[] array) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int item : array) {
            if (item > largest) {
                secondLargest = largest;
                largest = item;
            }
            else if (item > secondLargest && item != largest) {
                secondLargest = item;
            }
        }

        System.out.println("Largest : " + largest);
        System.out.println("Second Largest : " + secondLargest);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 6, 7, 5};
        largestAndSecondLargest(array);
    }
}
