package recursion.AllCombinations;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {
    private static final  int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static final char[] directions = {'D', 'R', 'U', 'L'};

    public static List<String> findPath(int[][] maze, int n) {
        List<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];

        if (maze[0][0] == 0 || maze[n-1][n-1] == 0) {
            return result;
        }
        backtrack(maze, n, 0, 0, "", visited, result);
        return result;
    }

    private static void backtrack(int[][] maze, int n,int row, int col, String currentPath, boolean[][] visited, List<String> result) {
        if (row == n-1 && col == n-1) {
            result.add(currentPath);
            return;
        }

        visited[row][col] = true;

        for (int i = 0; i < dirs.length; i++) {
            int newRow = row + dirs[i][0];
            int newCol = col + dirs[i][1];

            if (isSafe(maze, n, newRow, newCol, visited)) {
                backtrack(maze, n,newRow, newCol, currentPath + directions[i], visited, result);
            }
        }

        visited[row][col] = false;
    }

    private static boolean isSafe(int[][] maze, int n,int row, int col, boolean[][] visited) {
        return  (row >= 0 && row < n && col >= 0 && col < n && maze[row][col] == 1 && !visited[row][col]);
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        int n = maze.length;

        List<String> paths = findPath(maze, n);
        if (paths.isEmpty()) {
            System.out.println("No Path Found!");
        }
        else {
            System.out.println("Paths from top-left to bottom-right:" + paths.size());
            for (String path : paths) {
                System.out.println(path);
            }
        }
    }

}
