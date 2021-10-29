package sample;

import java.util.ArrayList;
import java.util.List;

public class q7 {

    // backtracking combination sum

    // Time - O(N ^ T/M + 1)
    // Space - O(T/M)

    List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTracking(candidates, target, new ArrayList<>(), 0);

        return output;
    }

    public void backTracking(int[] candidates, int target, List<Integer> path, int index){
        if(target < 0){
            return;
        }
        if(target == 0){
            output.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            backTracking(candidates, target - candidates[i], path, i);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}
