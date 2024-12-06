package binarySearch.bsOnMatrixes;

import java.util.Arrays;

public class SearchInRowAndColumnWiseSortedMatrix {
    public static int[] search(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0, col = cols - 1;

        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return new int[] {row, col};
            }
            else if (matrix[row][col] < target) {
                row++;
            }
            else {
                col--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int key = 27;
        System.out.println("MATRIX: ");
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
