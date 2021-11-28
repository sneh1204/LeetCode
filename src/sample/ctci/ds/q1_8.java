package sample.ctci.ds;

import java.util.ArrayList;
import java.util.Arrays;

public class q1_8 {

    public static void makeZero(int[][] matrix){
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (Integer row:
             rows) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[row][i] = 0;
            }
        }

        for (Integer col:
                cols) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
    }

    public static void makeZeroConstantSpace(int[][] matrix){
        boolean colHasZero = false;
        boolean rowHasZero = false;

        for (int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0){
                rowHasZero = true;
                break;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0){
                colHasZero = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0; // col
                    matrix[i][0] = 0; // row
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if(matrix[i][0] == 0){
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0){
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }


        if(rowHasZero){
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if(colHasZero){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 2, 3}, {4, 0, 6}, {7, 8, 9}};
        makeZeroConstantSpace(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

}
