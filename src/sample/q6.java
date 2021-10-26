package sample;

public class q6 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[0].length == 0)  return null;

        if(image[sr][sc] == newColor) return image;

        // dfs
        dfs(image, sr, sc, image[sr][sc], newColor);

        return image;
    }

    public void dfs(int[][] image, int row, int col, int color, int newColor){
        if(row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != color) return;

        image[row][col] = newColor;

        int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}}; // directions array
        for (int[] dir : dirs)
            dfs(image, row + dir[0], col + dir[1], color, newColor);
    }

    public static void main(String[] args) {
    }

}
