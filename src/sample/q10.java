package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q10 {

    static final int SIZE = 4;
    static int[] arr = new int[SIZE];

    public static void allPossibleString(int n){
        if(n <= 0) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        arr[n - 1] = 0;
        allPossibleString(n - 1);
        arr[n - 1] = 1;
        allPossibleString(n - 1);

    }

    public static void main(String[] args) {
        //allPossibleString(SIZE);
        System.out.println(subsets(new int[]{1,2,3}));
    }

    static List<List<Integer>> output = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0, new ArrayList<>());

        return output;
    }

    public static void backtracking(int[] nums, int index, List<Integer> path){
        output.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
