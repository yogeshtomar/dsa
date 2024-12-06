package graphs.traversal;

public class FloodFill {
    private static int n;
    private static int m;
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColour) {
        n = image.length;
        m = image[0].length;

        if (image[sr][sc] == newColour) {
            return image;
        }

        dfs(image, sr, sc, image[sr][sc], newColour);
        return image;
    }

    private static void dfs(int[][] image, int i, int j, int color, int newColor) {
        if (i < 0 || i >= n || j < 0 || j >= m || image[i][j] != color) return;

        image[i][j] = newColor;
        dfs(image, i+1, j, color, newColor);
        dfs(image, i-1, j, color, newColor);
        dfs(image, i, j+1, color, newColor);
        dfs(image, i, j-1, color, newColor);
    }

    public static void main(String[] args) {
        int[][] image =  {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        int[][] ans = floodFill(image, 1, 1, 2);
        System.out.println("floodFill image :");
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
