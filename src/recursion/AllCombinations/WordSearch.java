package recursion.AllCombinations;

import java.util.Arrays;

public class WordSearch {
    public static boolean exists(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        int index = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(index)) {
                    if (searchNext(board, word, i, j, index, m, n)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean searchNext(char[][] board, String word, int i, int j, int index, int m, int n) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= m || j >= m || board[i][j] != word.charAt(index) || board[i][j]  == '!') {
            return false;
        }

        char c = board[i][j];
        board[i][j] = '!';

        boolean top = searchNext(board, word, i - 1, j, index + 1, m, n);
        boolean bottom = searchNext(board, word, i + 1, j, index + 1, m, n);
        boolean left = searchNext(board, word, i, j-1, index + 1, m, n);
        boolean right = searchNext(board, word, i, j+1, index+1, m, n);

        board[i][j] = c;
        return top || bottom || left || right;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};

        String word = "ABCCED";
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("The word \"" + word + "\" exists in the board: " + exists(board, word));
    }
}
