package graphs.shortestpathalgos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.util.Arrays.fill;

public class PathWithMinimumEffort {
    static class Pair {
        int dist;
        int row;
        int col;
        public Pair(int dist, int row, int col) {
            this.dist = dist;
            this.row = row;
            this.col = col;
        }
    }

    private static int minimumEffortPath(int[][] heights) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] distance = new int[rows][cols];
        for (int[] a : distance) {
            Arrays.fill(a, Integer.MAX_VALUE);
        }

        Queue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return a.dist - b.dist;
            }
        });

        minHeap.add(new Pair(0, 0, 0));
        distance[0][0] = 0;

        while (!minHeap.isEmpty()) {
            Pair cur = minHeap.poll();
            int dist = cur.dist;
            int r = cur.row;
            int c = cur.col;

            if (r == rows-1 && c == cols-1) {
                return dist;
            }

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nc >= 0 && nr < rows && nc < cols) {
                    int newDist = Math.max(dist, Math.abs(heights[nr][nc] - heights[r][c]));
                    if (newDist < distance[nr][nc]) {
                        distance[nr][nc] = newDist;
                        minHeap.add(new Pair(newDist, nr, nc));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] heights={{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println("val of path with min effort is : " + minimumEffortPath(heights));

        int[][] heights2 = {{1,2,3}, {3, 8, 4}, {5, 3, 5}};
        System.out.println("val of path with min effort is : " + minimumEffortPath(heights2));


    }
}
