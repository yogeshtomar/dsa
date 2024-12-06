package graphs.shortestpathalgos;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInABinaryMaze {
    private static final int[][] dirs = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1,-1}, {0, -1}, {1, -1}};
    public static int shortestPathBinaryMatrix(int[][] grid, int[] source, int[] destination) {
        if (source[0] == destination[0] && source[1] == destination[1]) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(source);
        visited[source[0]][source[1]] = true;

        int len = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == m-1 && cur[1] == n-1){
                    return len+1;
                }
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x >= 0 && y >= 0 && x < m && y < n && !visited[x][y] && grid[x][y] == 0) {
                        visited[x][y] = true;
                        queue.add(new int[] {x, y});
                    }
                }
            }
            ++len;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}};
        int[] source = {0, 0};
        int[] destination = {2, 2};

        System.out.println("distance: " + shortestPathBinaryMatrix(grid, source, destination));

        int[][] graph = {
                {0, 1},
                {1, 0}
        };
        System.out.println("distance: " + shortestPathBinaryMatrix(graph, new int[] {0, 0}, new int[] {1, 1}));
    }
}
