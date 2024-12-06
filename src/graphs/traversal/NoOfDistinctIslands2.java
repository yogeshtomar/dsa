package graphs.traversal;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfDistinctIslands2 {
    private static class IndexPair {
        int row;
        int col;
        public IndexPair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int distinctIslands(int[][] grid) {
        int m = grid.length;;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    count++;
                    bfs(grid, i, j, visited);
                }
            }
        }
        return count;
    }

    private static void bfs(int[][] grid,int row, int col, boolean[][] visited) {
        visited[row][col] = true;
        Queue<IndexPair> queue = new LinkedList<>();
        queue.add(new IndexPair(row, col));
        int m = grid.length;
        int n = grid[0].length;

        while (!queue.isEmpty()) {
            IndexPair current = queue.poll();
            int curRow = current.row;;
            int curCol = current.col;

            for (int dirRow = -1; dirRow <= 1; dirRow++) {
                for (int dirCol = -1; dirCol <=1; dirCol++) {
                    int i = curRow + dirRow;
                    int j = curCol + dirCol;

                    if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1 && !visited[i][j]) {
                        visited[i][j] = true;
                        queue.add(new IndexPair(i, j));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 1, 0}
        };

        System.out.println(distinctIslands(grid));
    }
}
