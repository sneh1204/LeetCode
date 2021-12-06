package sample.fbprep;

import java.util.Arrays;

public class MoveZeroes {

    public static void rearrangeInPlace(int[] nums){
        if(nums == null || nums.length <= 1) return;

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[count++] = nums[i];
            }
        }

        for (int i = count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,8,0,2,2,0,10};
        rearrangeInPlace(nums);
        System.out.println(Arrays.toString(nums));
    }
}
