package binarySearch.bsOnMatrixes;

import java.util.Arrays;

public class SearchInA2dMatrix {
    public static int[] search(int[][] matrix, int key) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0, high = rows * cols - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            int row =  mid/cols, col = mid % cols;
            if (matrix[row][col] == key) {
                return new int[] {row, col};
            }
            else if (matrix[row][col] < key) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                            {1, 2, 3, 4},
                            {5, 6, 7, 8},
                            {9, 10, 11, 12}
                        };
        int key = 7;
        System.out.println("Matrix:");
        printMatrix(matrix);

        int[] ans = search(matrix, key);
        System.out.println(ans != null ? "The target: " + key + " is found at index: " + Arrays.toString(ans) : "The target is not found in the matrix");
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%6d", matrix[row][col]);
            }
            System.out.println();
        }
    }
}
