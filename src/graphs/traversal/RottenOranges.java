package graphs.traversal;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        // put all rotten oranges in queue and count fresh oranges
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[] {i, j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;

        int count = 0;
        while(!queue.isEmpty()) {
            ++count;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int cell[] = queue.poll();
                for(int[] dir : dirs){
                    int x = cell[0] + dir[0];
                    int y = cell[1] + dir[1];
                    if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || grid[x][y] == 2){
                        continue;
                    }
                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y});
                    fresh--;
                }
            }
        }

        return fresh == 0 ? count-1 : -1;
    }

    public static void main(String[] args) {
        int[][] arr ={ {2,1,1} , {1,1,0} , {0,1,1} };
        int rotting = orangesRotting(arr);
        System.out.println("Minimum Number of Minutes Required "+rotting);
    }
}
