package sample;

import java.util.ArrayList;
import java.util.List;

public class q8 {

    // backtracking subsets

    List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0, new ArrayList<>());

        return output;
    }

    public void backtracking(int[] nums, int index, List<Integer> path){
        output.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}
