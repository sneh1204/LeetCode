package sample.fbprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

    // TC - O(nlogn) (sorting)
    // SC - O(N)

    public static int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <= 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        ArrayList<int[]> output = new ArrayList<>();

        int[] current_interval = intervals[0];
        output.add(current_interval);

        for (int i = 1; i < intervals.length; i++) {
            int[] current = current_interval;
            int[] next = intervals[i];

            if(current[1] >= next[0]){
                current_interval[1] = Math.max(current[1], next[1]);
            }else{
                current_interval = intervals[i];
                output.add(current_interval);
            }

        }

        return output.toArray(new int[output.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1,3},{2,6},{5,10},{15,18}})));
    }

}
