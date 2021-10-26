package sample;

import java.util.LinkedList;
import java.util.Queue;

public class q5 {

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1'){
                    count++;

                    grid[i][j] = '0';

                    //BFS
                    Queue<int[]> queue = new LinkedList<>();

                    // Base
                    queue.add(new int[]{i, j});
                    while(!queue.isEmpty()){
                        int[] item = queue.remove();

                        int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}}; // directions array
                        for (int[] dir : dirs) {
                            int new_row = item[0] + dir[0];
                            int new_col = item[1] + dir[1];
                            if(new_row >= 0 && new_row < m && new_col >= 0 && new_col < n && grid[new_row][new_col] == '1'){ // check out of bounds and if land
                                queue.add(new int[]{new_row, new_col});
                                grid[new_row][new_col] = '0'; // make it water
                            }
                        }
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }

}
