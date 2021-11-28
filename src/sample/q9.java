package sample;

import java.util.HashSet;

public class q9 {

    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hashSet = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];

                if(val == '.') continue;

                if(!hashSet.add(val + " row " + i) || !hashSet.add(val + " col " + j) || !hashSet.add(val + " box " + i/3 + " - " + j/3)) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
