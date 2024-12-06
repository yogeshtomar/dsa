package recursion.AllCombinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time Complexity:O(N!), where N is the number of queens, due to generating all possible solutions.
 * Space Complexity:O(N^2), used by the board and the recursion stack
 *
 */

public class NQueen {
    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c,'#');
        }

        List<List<String>> result = new ArrayList<>();
        dfs(board, 0, result);
        return result;
    }

    private static void dfs(char[][] board, int row, List<List<String>> result) {
        if (row == board.length) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                dfs(board, row + 1, result);
                board[row][col] = '#';
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // Check upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private static List<String> construct(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> queen = solveNQueens(n);
        for (int i = 0; i < queen.size(); i++) {
            for (int j = 0; j < queen.get(i).size(); j++) {
                System.out.println(queen.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}
