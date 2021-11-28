package sample.ctci.ds;

import java.util.Arrays;

public class q1_7 {

    public static void matrixRotate90(int[][] matrix){
        if(matrix == null || matrix.length != matrix[0].length) return;

        for (int i = 0; i < matrix.length; i++) { // get transpose
            for (int j = i + 1; j < matrix[0].length; j++) {
                int temp = matrix[i][j]; // swap
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) { // reverse row
            int left = 0, right = matrix.length - 1;
            while(left < right){
                int temp = matrix[i][right];
                matrix[i][right] = matrix[i][left];
                matrix[i][left] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrixRotate90(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
