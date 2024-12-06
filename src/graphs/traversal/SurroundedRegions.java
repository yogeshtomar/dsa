package graphs.traversal;

public class SurroundedRegions {
    public static void surroundedRegions(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        if (board.length < 3 || board[0].length == 3) return;

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            if (board[i][0] == '0') dfs(board, i, 0);
            if (board[i][row-1] == '0') dfs(board, i, row-1);
        }

        for (int j = 1; j < col-1; j++) {
            if (board[0][j] == '0') dfs(board, 0, j);
            if (board[row-1][j] == '0') dfs(board, row-1, j);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '0') board[i][j] = 'X';
                if (board[i][j] == '*') board[i][j] = '0';
            }
        }
    }

    private static void dfs(char[][] board, int i, int j) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == '0') {
            board[i][j] = '*';
            dfs(board, i+1, j);
            dfs(board, i-1, j);
            dfs(board, i, j+1);
            dfs(board, i, j-1);
        }
    }
}
