package sample;

import java.util.Arrays;

public class good_segment {

    private static int getLongestSegment(int[] badNumbers, int lower, int upper) {
        if(badNumbers == null || badNumbers.length <= 0) return 0; // null check

        int longest = 0, lastNumber = lower + 1;

        Arrays.sort(badNumbers);

        for (int i = 0; i < badNumbers.length && badNumbers[i] <= upper; i++) {
            if(lower > badNumbers[i]) continue; // left check

            longest = Math.max(longest, badNumbers[i] - lastNumber);

            lastNumber = badNumbers[i] + 1; // update last good number
        }

        if(upper > lastNumber){ // right check
            longest = Math.max(longest, upper - lastNumber);
        }

        return longest;
    }

    // Time complexity - O(length of badnumbers array)
    // Space complexity - O(1)

    public static void main(String[] args) {
        System.out.println(getLongestSegment(new int[]{5, 2, 4, 15}, 1, 20)); // 9
        System.out.println(getLongestSegment(new int[]{6, 7, 8, 9}, 1, 9)); // 4
        System.out.println(getLongestSegment(new int[]{5, 2, 4, 15}, 4, 10)); // 4
        System.out.println(getLongestSegment(new int[]{37, 7, 22, 15, 49, 60}, 3, 48)); // 14
        System.out.println(getLongestSegment(new int[]{1, 2, 3, 4}, 1, 4)); // 0
    }
}
