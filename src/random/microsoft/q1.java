package random.microsoft;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class q1 {

    /**
     * Given a two-dimensional array, if any element within is zero, make its whole row and column zero.
     * For example, consider the matrix below.
     *
     * There are two zeros in the input matrix at position (1,1) and (2,3).
     * The output of this should be a matrix in which the first and second rows become zero and first and third columns become zeros.
     * Below is the expected output matrix.
     */

    static void make_zeroes(int[][] matrix) {
        if(matrix.length == 0)  return;

        Set<Integer> zero_rows = new HashSet<>();
        Set<Integer> zero_cols = new HashSet<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == 0){
                    zero_rows.add(i);
                    zero_cols.add(j);
                }
            }
        }

        for(int r : zero_rows){
            for(int i = 0; i < cols; i++){
                matrix[r][i] = 0;
            }
        }

        for(int c : zero_cols){
            for(int i = 0; i < rows; i++){
                matrix[i][c] = 0;
            }
        }
    }

    static int[][] create_random_matrix(int rows, int cols) {
        int[][] v = new int[rows][cols];

        for(int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                int t = new Random().nextInt() % 100;
                v[i][j] = t + 1;
                if (Math.abs(t) % 100 <= 5) {
                    v[i][j] = 0;
                }
            }
        }
        return v;
    }

    static void print_matrix(int[][] m) {
        System.out.println();
        for (int[] ints : m) {
            for (int anInt : ints) {
                System.out.print(anInt);
                System.out.print("\t");
            }
            System.out.println();
        }
    }
    static boolean is_row_or_col_zero(int[][] matrix, int r, int c) {
        int rows = matrix.length;
        int cols = 0;
        if (rows > 0) {
            cols = matrix[0].length;
        }

        for (int i = 0; i < cols; ++i) {
            if (matrix[r][i] == 0) {
                return true;
            }
        }

        for (int[] ints : matrix) {
            if (ints[c] == 0) {
                return true;
            }
        }

        return false;
    }

    static void verify(int[][] matrix) {
        int[][] mat_copy = new int[matrix.length][];
        for (int i = 0; i < matrix.length; ++i) {
            mat_copy[i] = matrix[i].clone();
        }

        make_zeroes(matrix);

        int rows = matrix.length;
        int cols = 0;
        if (rows > 0) {
            cols = matrix[0].length;
        }

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                assert !is_row_or_col_zero(mat_copy, i, j) || (matrix[i][j] == 0);
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 45, 0, 81},
                {6, 7, 2, 82, 8},
                {20, 22, 49, 5, 5},
                {0, 23, 50, 4, 92}
        };
        print_matrix(matrix);
        verify(matrix);
        print_matrix(matrix);

        matrix = create_random_matrix(5, 5);
        print_matrix(matrix);
        verify(matrix);
        print_matrix(matrix);

        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                matrix = create_random_matrix(i, j);
                verify(matrix);
            }
        }
    }


}
