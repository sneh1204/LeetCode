package sample;

import java.util.ArrayList;
import java.util.List;

public class q1 {

    /**
     * Pascal triangle
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        if(numRows <= 0) return new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();

        output.add(new ArrayList<>(List.of(1)));
        if(numRows == 1) return output;

        for (int i = 1; i < numRows; i++) {
            List<Integer> add = new ArrayList<>();
            add.add(1);

            List<Integer> prev = output.get(i - 1);
            for (int j = 1; j < i; j++) {
                add.add(prev.get(j) + prev.get(j - 1));
            }

            add.add(1);

            output.add(add);
        }

        return output;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
