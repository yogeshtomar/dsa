package graphs.mst;

import java.util.HashSet;
import java.util.Set;

public class MakingALargeIsland {
    private boolean isValid (int rewR, int newC, int n) {
        return rewR >= 0 && rewR < n && newC >= 0 && newC < n;
    }
    public int maxConnection(int[][] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind(n * n);
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                for (int[] dir : dirs) {
                    int newR = i + dir[0];
                    int newC = j + dir[1];
                    if (isValid(newR, newC, n) && grid[newR][newC] == 1) {
                        int nodeNo = i * n + j;
                        int adjNodeNo = newR * n + newC;
                        uf.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                Set<Integer> components = new HashSet<>();
                for(int[] dir : dirs) {
                    int newR = i + dir[0];
                    int newC = j + dir[1];
                    if (isValid(newR, newC, n)) {
                        if (grid[newR][newC] == 1) {
                            components.add(uf.findParent(newR * n + newC));
                        }
                    }
                    int sizeTotal = 0;
                    for (int parents : components) {
                        sizeTotal += uf.size.get(parents);
                    }
                    max = Math.max(max, sizeTotal + 1);
                }
            }
        }
        for (int i = 0; i < n*n; i++) {
            max = Math.max(max, uf.size.get(uf.findParent(i)));
        }
        return  max;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 1, 1, 0}, {1, 1, 0, 1, 1, 0},
                {1, 1, 0, 1, 1, 0}, {0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 0}, {0, 0, 1, 1, 1, 0}
        };

        MakingALargeIsland sol = new MakingALargeIsland();
        System.out.println("Size of the Largest group of Connected 1's is :" + sol.maxConnection(grid));
    }
}
