package graphs.mst;

import java.util.ArrayList;
import java.util.List;

public class NoOfIslands2 {
    private boolean isValid(int adjr, int adjc, int n, int m) {
        return adjr >= 0 && adjr < n && adjc >= 0 && adjc < m;
    }

    public List<Integer> numOfIslands(int n, int m, int[][] operations) {
        UnionFind uf = new UnionFind(n * m);
        int[][] visited = new int[n][m];
        int count = 0;
        List<Integer> ans = new ArrayList<>();
        int len = operations.length;
        for (int i = 0; i < len ; i++) {
            int row = operations[i][0];
            int col = operations[i][1];
            if (visited[row][col] == 1) {
                ans.add(count);
                continue;
            }
            visited[row][col] = 1;
            count++;
            int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            for (int[] dir : dirs) {
                int adjr = row + dir[0];
                int adjc = col + dir[1];
                if (isValid(adjr, adjc, n, m)) {
                    if (visited[adjr][adjc] == 1) {
                        int nodeNo = row * m + col;
                        int adjRowNo = adjr * m + adjc;
                        if (uf.findParent(nodeNo) != uf.findParent(adjRowNo)) {
                            count--;
                            uf.unionBySize(nodeNo, adjRowNo);
                        }
                    }
                }
                
            }
            ans.add(count);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 4, m = 5;
        int[][] operators = {{0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1},
                {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}
        };

        NoOfIslands2 sol = new NoOfIslands2();
        List<Integer> res = sol.numOfIslands(n, m, operators);
        System.out.println(res.toString());

    }
}
