package graphs.traversal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearest1sInBinaryMatrix {
    private static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int[][] dirs = {{1, 0,}, {-1, 0}, {0, 1}, {0, -1}};

    public static int[][] nearestOnes(int[][] matrix) {
        Queue<Point> queue = new LinkedList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] distance = new int[n][m];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    distance[i][j] = 0;
                    queue.add(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int[] dir : dirs) {
                int i = cur.x + dir[0];
                int j = cur.y + dir[1];

                if (i >= 0 && i < n && j >= 0 && j < m) {
                    if (distance[i][j] > distance[cur.x][cur.y] + 1) {
                        distance[i][j] = distance[cur.x][cur.y] + 1;
                        queue.add(new Point(i, j));
                    }
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,1,1,0},
                {1,1,0,0},
                {0,0,1,1}
        };

        int[][] ans = nearestOnes(grid);
        for (int[] an : ans) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(an[j] + " ");
            }
            System.out.println();
        }
    }
}
