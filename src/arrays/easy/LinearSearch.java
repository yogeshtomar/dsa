package arrays.easy;

public class LinearSearch {
    public static int search(int[] array, int item) {
        int i = 0;
        for (i = 0; i < array.length; i++) {
            if (array[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int num = 4;
        int index = search(array, num);
        System.out.println(index == -1 ? "Not found" : "found at index: " + index);
    }
}
