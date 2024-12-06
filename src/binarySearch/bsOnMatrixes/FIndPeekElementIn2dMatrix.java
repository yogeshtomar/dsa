package binarySearch.bsOnMatrixes;

public class FIndPeekElementIn2dMatrix {
    public static int[] findPeekGrid(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int startRow = 0;
        int endRow = rows - 1;

        while (startRow <= endRow) {
            int midRow = startRow + (endRow - startRow)/2;
            int maxCol = findMaxInRow(matrix[midRow]);

            boolean isTopGreater = midRow > 0 && matrix[midRow][maxCol] < matrix[midRow-1][maxCol];
            boolean isBottomGreater = midRow < rows-1 && matrix[midRow][maxCol] < matrix[midRow+1][maxCol];

            if (!isTopGreater && !isBottomGreater) {
                return new int[] {midRow, maxCol};
            }
            else if (isTopGreater) {
                endRow = midRow - 1;
            }
            else {
                startRow = midRow + 1;
            }
        }
        return new int[]{-1, -1};
    }

    private static int findMaxInRow(int[] row)  {
        int maxIndex = 0;
        for (int i = 1; i < row.length; i++) {
            if (row[i] > row[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 3},
                {6, 7, 8},
                {5, 9, 2}
        };

        int [] ans = findPeekGrid(matrix);
        System.out.println("Peak found at: [" + ans[0] + ", " + ans[1] + "]");
    }

}
