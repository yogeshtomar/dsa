package binarySearch.bsOnMatrixes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RowWIthMaximumNoOfOnes {
    public static int rowWithMax1s(List<List<Integer>> matrix, int rows, int cols) {
        int maxCount = 0;
        int index = -1;

        for (int i = 0; i < rows; i++) {
            int count = cols - lowerBound(matrix.get(i), cols, 1);
            if (count > maxCount) {
                maxCount = count;
                index = i;
            }
        }
        return index;
    }
    private static int lowerBound(List<Integer> list, int cols, int key) {
        int low = 0, high = cols - 1;
        int ans = cols;

        while (low <= high) {
            int mid = low + (high - low)/2;
            if (list.get(mid) >= key) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0)));

        int n = 3, m = 3;
        int ans = rowWithMax1s(matrix, n, m);
        System.out.println("The row with max 1s is : " + ans);
        System.out.println(matrix.get(ans).toString());
    }
}
